package com.servlet;

import java.io.IOException;

import com.dao.PostDAO;
import com.db.DBConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/NoteEdit")
public class NoteEditServlet extends HttpServlet {

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int noteid=Integer.parseInt(request.getParameter("noteid"));
		String title= request.getParameter("title");
		String content=request.getParameter("content");
		try {
			PostDAO po=new PostDAO(DBConnect.getCon());
			boolean f=po.PostUpdateMethod(noteid, title, content);
			if(f)
			{
				System.out.print("Data updated");
				HttpSession session=request.getSession();
				session.setAttribute("UpdateMsg", "Successfully Updated the Notes");
				response.sendRedirect("showNotes.jsp");
			}
			else
			{
				System.out.print("Data not updated");
			}
			
		} catch (Exception e) {

			e.printStackTrace();
		
		}
	}

}
