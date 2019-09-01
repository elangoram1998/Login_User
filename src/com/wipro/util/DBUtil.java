package com.wipro.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	public static Connection getCon()
	{
		Connection con=null;
		String url="jdbc:mysql://localhost:3306/user_login";
		String uname="root";
		String pass="1234";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,uname,pass);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
}
