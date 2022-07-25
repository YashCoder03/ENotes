<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.PostDAO"%>
<%@page import="java.util.*"%>
<%@page import="com.user.Post"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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
<title>Show Notes</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body>
	<%@include file="all_component/navbar.jsp"%>
		<%
String msg=(String)session.getAttribute("UpdateMsg");
if(msg!=null)
{
%>
	<div class="alert alert-success" role="alert"><%=msg%></div>
	
<%
session.removeAttribute("updateMsg");}%>

		<%
String msg1=(String)session.getAttribute("DeleteMsg");
if(msg1!=null)
{
%>
	<div class="alert alert-success" role="alert"><%=msg1%></div>
	
<%
session.removeAttribute("updateMsg");}%>



	
	<div class="container">

		<div class="col-md-12">
			<%
			if (us1 != null) {
				PostDAO ob = new PostDAO(DBConnect.getCon());
				List<Post> post = ob.getData(us1.getId());
				for (Post po : post) {
			%>
			<div class="card mt-3">
				<div class="card-body p-4">

					<h5 class="card-title"><%=po.getTitle() %></h5>
					<p><%=po.getContent() %></p>
					<p>

						<b class="text-success"> Published by</b><br> <b
							class="text-primary"><%=us1.getName()%></b><br> 
						<b class="text-success"> Date</b><br> 
						<b class="text-primary"><%=po.getPdate() %></b>
					<div class="container text-center mt-2">
						<a href="DeleteServlet?note_id=<%=po.getId() %>" class="btn btn-primary">Delete</a>
						<a href="edit.jsp?note_id=<%=po.getId() %>" class="btn btn-primary">Edit</a>

					</div>

				</div>

			</div>



			<%
			}
			}
			%>
		</div>

	</div>


</body>
</html>