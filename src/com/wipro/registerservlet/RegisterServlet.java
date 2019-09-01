package com.wipro.registerservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wipro.bean.RegisterBean;
import com.wipro.service.Service;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Firstname=request.getParameter("firstname");
		String Lastname=request.getParameter("lastname");
		String Emailid=request.getParameter("emailid");
		String UserId=request.getParameter("userid");
		String Password=request.getParameter("password");
		RegisterBean bean=new RegisterBean(Firstname,Lastname,Emailid,UserId,Password);
		Service s=new Service();
		if(s.existingUser(UserId, Password)) 
		{
			PrintWriter out=response.getWriter();  
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('User already Registered');"); 
			out.println("location='Register.jsp'");
			out.println("</script>");
		}
		else if(s.insertData(bean))
		{
			RequestDispatcher rd=request.getRequestDispatcher("RegisterSuccess.jsp");
			rd.forward(request, response);
		}
	}

}
