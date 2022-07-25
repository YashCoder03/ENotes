<%@page import="com.db.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@page import="com.dao.PostDAO" %>
<%@page import="com.user.Post" %>
<%
UserDetails us1 = (UserDetails) session.getAttribute("UserD");
if (us1 == null) {
	response.sendRedirect("login.jsp");
	session.setAttribute("Loginerror", "Please Login");
}
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body>

<% 
int a=Integer.parseInt(request.getParameter("note_id"));

PostDAO post=new PostDAO(DBConnect.getCon());

Post p=post.getDataById(a);


%>
	<div class="container-fluid">
		<%@include file="all_component/navbar.jsp"%>

		<h1 class="text-center">Edit Notes</h1>

		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<form action="NoteEdit" method="post">
					
					<input type="hidden" value="<%=a %>" name="noteid">
						<div class="form-group">

						
							<label for="exampleInputEmail1">Enter Title</label> <input
								type="text" class="form-control" id="exampleInputEmail1"
								aria-describedby="emailHelp" name="title" value="<%=p.getTitle() %>">
						</div>

						<div class="form-group">
							<label for="exampleInputEmail1">Enter Content</label>
							<textarea rows="12" cols="" class="form-control" name="content" ><%=p.getContent() %></textarea>
						</div>
						<div class="container text-center">
							<button type="submit" class="btn btn-primary">Edit Notes</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%@include file="all_component/footer.jsp"%>

</body>
</html>