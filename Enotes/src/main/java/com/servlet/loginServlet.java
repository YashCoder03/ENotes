package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import com.dao.UserDAO;
import com.db.DBConnect;
import com.user.UserDetails;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/login")
public class loginServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		String email=request.getParameter("useremail");
		String password=request.getParameter("userpassword");
		
		UserDetails us=new UserDetails();
		us.setEmail(email);
		us.setPassword(password);
		UserDAO dao=null;
		try {
			dao=new UserDAO(DBConnect.getCon());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserDetails user=dao.loginUser(us);
		if(user!=null)
		{
			HttpSession session=request.getSession();
			session.setAttribute("UserD",user);
			response.sendRedirect("home.jsp");
			System.out.print(user.getName());
		}
		else
		{
			HttpSession session=request.getSession();
			session.setAttribute("login-failed", "Invalid userName and Password");
			response.sendRedirect("login.jsp");
		}
		
	}

}
