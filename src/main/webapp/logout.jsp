<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	
	
	
	<%
		session.removeAttribute("user");
		session.invalidate();
		response.setHeader("cache-Control","no-cache,no-store,must-revalidate"); 
	 	response.setHeader("Pragma","no-cache");    
	 	response.setHeader("Expires","0");
			
		response.sendRedirect("login.jsp");
	%>
	
</body>
</html>