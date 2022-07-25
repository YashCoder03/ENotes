package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import com.dao.PostDAO;
import com.db.DBConnect;
import com.user.Post;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddNotes")
public class AddNotesServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		int uid=Integer.parseInt(request.getParameter("uid"));
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		PostDAO dao=null;
		try {
			dao=new PostDAO(DBConnect.getCon());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean f= dao.AddNotes(title, content, uid);
		
		if(f)
		{
			System.out.print("Data Inserted");
			response.sendRedirect("showNotes.jsp");
		}
		else
		{
			System.out.print("Not Inserted");
		}
		
	}

}
