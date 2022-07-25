package com.servlet;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.dao.UserDAO;
import com.db.DBConnect;
import com.user.UserDetails;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException 
	{
		String name=req.getParameter("username");
		String email=req.getParameter("useremail");
		String password=req.getParameter("userpassword");
		
		UserDetails us =new UserDetails();
		us.setName(name);
		us.setEmail(email);
		us.setPassword(password);
		
		PrintWriter out=res.getWriter();
		
			UserDAO ud = null;
			try {
				ud = new UserDAO(DBConnect.getCon());
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			boolean f=ud.addUser(us);
			HttpSession session;
			if(f)
			{
				session=req.getSession();
				session.setAttribute("reg-sucess","Registration Sucessfully.");
				res.sendRedirect("register.jsp");
			}
			else
			{
				session=req.getSession();
				session.setAttribute("failed-msg", "Something went wrong");
				res.sendRedirect("register.jsp");
			}
		
	}

}
