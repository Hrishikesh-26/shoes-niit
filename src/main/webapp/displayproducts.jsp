<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
 <%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<sql:setDataSource driver="com.mysql.jdbc.Driver"
							url="jdbc:mysql://35.232.120.71/shoes"
							user="root"
							password="root"
							var="mydatasource" />
		 
	<sql:query var="data" dataSource="${mydatasource}">
		select * from products
	</sql:query>
<div class="container">
    
    <div class="row">
    <c:forEach items="${data.rows}" var="row">
        <div class="col-md-3 col-sm-6">
            <div class="product-grid">
                <div class="product-image">
                <br>
                <br>
                <br>
                    <a href="displayproduct.jsp?productid=${row.productid}">
                        <img  class="pic-1 col-lg-12 col-md-12 col-sm-12 col-xs-12" src="ImageServlet?productid=${row.productid}" class="img-responsive">
                    </a>
                   
                
                    
                </div>
               
                <div >
                    <h3 class="title"><a href="#">${row.name}</a></h3>
                    <h3 class="title"><a href="#">Rs. ${row.price}</a></h3>
                </div>
            </div>
        </div>
        </c:forEach>
    </div>
    
</div>
<hr>
		
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>