<%@page import="java.nio.file.attribute.UserDefinedFileAttributeView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%
	UserDetails us1=(UserDetails)session.getAttribute("UserD");	
	if(us1==null)
	{
		response.sendRedirect("login.jsp");
		session.setAttribute("Loginerror", "Please Login");
	}
	
	%>
	
	
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Notes</title>

<%@include file="all_component/allcss.jsp"%>
</head>
<body>

	<div class="container-fluid">
		<%@include file="all_component/navbar.jsp"%>
		
		<h1 class="text-center">Add Your Notes</h1>
		
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<form action="AddNotes" method="post">
						<div class="form-group">
						
						<%
						UserDetails us=(UserDetails)session.getAttribute("UserD");
						if(us!=null)
						{%>
						<input type="hidden" name="uid" value=<%=user.getId() %>>	
						<%  }%>
						
						
						
							<label for="exampleInputEmail1">Enter Title</label> <input
								type="text" class="form-control" id="exampleInputEmail1"
								aria-describedby="emailHelp" name="title">
						</div>

						<div class="form-group">
							<label for="exampleInputEmail1">Enter Content</label>
							<textarea rows="12" cols="" class="form-control" name="content"></textarea>
						</div>
						<div class="container text-center">
							<button type="submit" class="btn btn-primary">Add Notes</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%@include file="all_component/footer.jsp" %>
</body>
</html>