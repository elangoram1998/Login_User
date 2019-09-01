package com.wipro.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.wipro.bean.LoginBean;
import com.wipro.bean.RegisterBean;
import com.wipro.util.DBUtil;

public class Service {
	public boolean insertData(RegisterBean bean)
	{
		String query="insert into userdata(firstname,lastname,emailid,userid,userpassword)values(?,?,?,?,?)";
		int i=0;
		try
		{
		Connection con=DBUtil.getCon();
		PreparedStatement pst=con.prepareStatement(query);
		pst.setString(1, bean.getFirstname());
		pst.setString(2,bean.getLastname());
		pst.setString(3, bean.getEmailid());
		pst.setString(4, bean.getUserid());
		pst.setString(5, bean.getPassword());
		i=pst.executeUpdate();
		if(i>0)
		{
			return true;
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	public boolean existingUser(String userid,String password)
	{
		String query="select * from userdata where userid=? and userpassword=?";
		try
		{
			Connection con=DBUtil.getCon();
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1, userid);
			pst.setString(2, password);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	public RegisterBean getUser(LoginBean bean)
	{
		RegisterBean registerbean=new RegisterBean();
		String query="select * from userdata where userid=? and userpassword=?";
		try
		{
			Connection con=DBUtil.getCon();
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1, bean.getUser_id());
			pst.setString(2, bean.getPassword());
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				registerbean.setFirstname(rs.getString(1));
				registerbean.setLastname(rs.getString(2));
				registerbean.setEmailid(rs.getString(3));
				registerbean.setUserid(rs.getString(4));
				registerbean.setPassword(rs.getString(5));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return registerbean;
	}
}
