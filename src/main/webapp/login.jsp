<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>

	.myform{margin:auto 0}

</style>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>



	<jsp:include page="header.jsp"></jsp:include>
		<div class="container">
			<form action="login" method="post" class="col-lg-6 col-md-6 col-sm-12 col-xs-12 myform">
			
			<h3 class="text-center text-info">Login</h3>
			
				<div class="form-group">
				
					<label>Enter Username:</label>
					<input type="text" name="username" placeholder="Your Username" class="form-control"/>
			
				</div>
			
				<div class="form-group">
					
					<label>Enter Password:</label>
					<input type="password" name="password" placeholder="Your Password" class="form-control"/>
			
				</div>
			
				<div class="form-group">
			
					<input type="submit" value="login" class="btn btn-primary btn-block">
					<input type="reset" value="reset" class="btn btn-danger btn-block">
			
				</div>	
				
				<div id="register-link" class="text-right">
                <a href="register.jsp" class="text-info">Register here</a>
                </div>
                
			</form>
		</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>