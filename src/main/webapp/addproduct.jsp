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
<style>
	.myform
	{
		margin:0 auto;
	}
</style>
</head>
<body>
	<sql:setDataSource driver="com.mysql.jdbc.Driver"
							url="jdbc:mysql://localhost:3306/shoes"
							user="root"
							password="hrishi"
							var="mydatasource" />
		 
	<sql:query var="data" dataSource="${mydatasource}">
		select * from products where productid=?
		<sql:param>${param.productid}</sql:param>
	</sql:query>
	
	<jsp:include page="header.jsp"></jsp:include>
		
		<div class="container">
		
	<form action="AddProductController" method="post" class="col-lg-6 col-md-6 col-sm-12 col-xs-12 myform" enctype="multipart/form-data">
			<div class="form-group">
				<label>Enter Name</label>
				<input type="text" name="name" class="form-control" placeholder="Enter Name" />
			</div>
			<div class="form-group">
				<label>Enter Price</label>
				<input type="text" name="price" class="form-control" placeholder="Enter Price" />
			</div>
			<div class="form-group">
				<label>Enter Category</label>
				<input type="text" name="category" class="form-control" placeholder="Enter Category"/>
			</div>
			<div class="form-group">
				<label>Enter Brand</label>
				<input type="text" name="brand" class="form-control" placeholder="Enter Brand" />
			</div>
			<div class="form-group">
				<label>Enter Size</label>
				<input type="text" name="size" class="form-control" placeholder="Enter Size" />
			</div>
			<div class="form-group">
				<label>Enter Colour</label>
				<input type="text" name="colour" class="form-control" placeholder="Enter Colour" />
			</div>
			<div class="form-group">
				<label>Enter Quantity</label>
				<input type="text" name="quantity" class="form-control" placeholder="Enter Quantity" />
			</div>
			<div class="form-group">
				<label>Enter Description</label>
				<input type="text" name="brand" class="form-control" placeholder="Enter description" />
			</div>
			<div class="form-group">
				<label>Select Image</label>
				<input type="file" name="image" class="form-control" placeholder="Select Image" />
			</div>
			<div class="form-group">
				<input type="submit" value="Add Product" class="btn btn-primary btn-block"/>
				<input type="reset" value="Reset" class="btn btn-danger btn-block"/>
			</div>
			</form>
		
			
	
		
		</div>
		
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>

