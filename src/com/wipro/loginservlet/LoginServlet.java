package com.wipro.loginservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wipro.bean.LoginBean;
import com.wipro.bean.RegisterBean;
import com.wipro.service.Service;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_Id=request.getParameter("user id");
		String Password=request.getParameter("password");
		Service s=new Service();
		if(s.existingUser(user_Id, Password))
		{
			LoginBean bean=new LoginBean(user_Id,Password);
			RegisterBean registerbean=new RegisterBean();
			registerbean=s.getUser(bean);
			request.setAttribute("firstname", registerbean.getFirstname());
			request.setAttribute("lastname", registerbean.getLastname());
			System.out.println(registerbean.getEmailid());
			RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);
		}
		else
		{
			PrintWriter out=response.getWriter();  
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('User does not exist');"); 
			out.println("location='Login.jsp'");
			out.println("</script>");
		}
	}

}
