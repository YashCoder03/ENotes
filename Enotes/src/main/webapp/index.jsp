<%@page import="com.db.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<%@include file="all_component/allcss.jsp"%>


<style types="text/css">
.back-img {
	background-image: url("img/Back.jpg");
	width: 100%;
	height: 91vh;
	background-repeat: no-repeat;
	background-size: cover;
}
</style>


</head>
<body>
	<%@include file="all_component/navbar.jsp"%>
	<div class="container-fluid back-img">
	
	<div class="text-center">
		<h1 class="text-white">E-Notes Save Your Notes</h1>
		<a href="login.jsp" class="btn btn-light">Login</a>
		<a href="register.jsp" class="btn btn-light">Register</a>
	</div>
	</div>
	<%@include file="all_component/footer.jsp"%>
</body>
</html>