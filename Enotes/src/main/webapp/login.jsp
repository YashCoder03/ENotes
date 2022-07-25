<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<%@include file="all_component/allcss.jsp"%>
<style type="text/css">
.div-color {
	background-image: linear-gradient(to left bottom, #051937, #004d7a, #008793, #00bf72,
		#a8eb12);
	height: 600px;
}
</style>


</head>
<body>
	<%@include file="all_component/navbar.jsp"%>
	<div class=".container-fluid div-color">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-4">
					<div class="card-header bg-custom ">
						<h4 class="text-center text-white">Login</h4>
					</div>
					
					<%
					String invalidMsg=(String)session.getAttribute("login-failed");
					
					if(invalidMsg!=null)
					{%>
						<div class="alert alert-danger" role="alert"><%=invalidMsg%></div>
					<% 	
					}
					session.removeAttribute("login-failed");
					%>
					
					<%
					String withoutlogin=(String) session.getAttribute("Loginerror");
					if(withoutlogin!=null)
					{%>
						<div class="alert alert-danger" role="alert"><%=withoutlogin%></div>
					
					<%
						session.removeAttribute("Loginerror");
					}
					%>
						
					<%
					String msg=(String)session.getAttribute("LogoutMsg");
					if(msg!=null)
					{%>
						<div class="alert alert-success" role="alert"><%=msg%></div>
					<% 
						session.removeAttribute("LogoutMsg");
					}
					
					%>
					
					<div class="card-body">
						<form action="login" method="post">


							<div class="form-group">
								<label>Enter E-Mail Address</label> <input type="email"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter email"
									name="useremail">

							</div>
							<div class="form-group">
								<label>Enter Password</label> <input type="password"
									class="form-control" id="exampleInputPassword1"
									placeholder="Password" name="userpassword">
							</div>

							<button type="submit"
								class="btn btn-primary badge-pill btn-block">Login</button>
						</form>
					</div>
				</div>

			</div>
		</div>
	</div>

	<%@include file="all_component/footer.jsp"%>
</body>
</html>