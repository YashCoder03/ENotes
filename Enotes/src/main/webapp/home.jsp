<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>

<%@include file="all_component/allcss.jsp"%>
</head>
<body>
	

	<div class="container-fluid p-0">
	<%@include file="all_component/navbar.jsp"%>
		<div class="card py-5">
			<div class="card-body text-center">
				<img alt="" src="img/unnamed.png" class="img-fluid mx-auto" style="max-width :400px;">
				<h1>Start Taking Note</h1>
				<a href="addNotes.jsp" class="btn btn-outline-primary">Start Here</a>
			</div>
		</div>
	</div>
	<%@include file="all_component/footer.jsp" %>
</body>
</html>