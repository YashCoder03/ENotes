package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import com.dao.PostDAO;
import com.db.DBConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("note_id"));
		PostDAO post=null;
		try {
			post=new PostDAO(DBConnect.getCon());
			boolean f=post.deleteNote(id);
			if(f)
			{
				System.out.print("deleted");
				HttpSession session =request.getSession();
				session.setAttribute("DeleteMsg","Successfully Deleted the Note");
				response.sendRedirect("showNotes.jsp");
			}
			else
			{
				System.out.print("Not Deleted");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	

}
