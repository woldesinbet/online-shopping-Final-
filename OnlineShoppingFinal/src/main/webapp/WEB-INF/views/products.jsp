<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Product</title>

</head>
<body>

	<h2>All Product</h2>
	<c:forEach items="${products}" var="products">
		<div
			style="border: 2px solid blue; width: 300px; float: left; margin: 5px">
			<p>Product Name: ${products.name }</p>

			<p>Price: ${products.price }</p>
			<p>Category: ${products.assignedcategory.name }</p>
			</p>
			<p>Quantity in Stock: ${products.quantitiy }</p>
			<p>Description: ${products.desribtion }</p>
			<br /> <a
				href="<spring:url value="/product?id=${products.productid}" /> ">
				</span> Details
			</a>
		</div>
	</c:forEach>

</body>
</html>