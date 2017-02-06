<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Product</title>
</head>
<body>

	<p>Product Name: ${product.name }</p>

	<p>Price: ${product.price }</p>
	<p>Quantity in Stock: ${product.quantitiy }</p>

	<p>Description: ${product.assignedcategory.name }</p>
	<security:authorize access="hasAuthority('ADMIN')">
		<a
			href="<spring:url value="/deleteProduct?id=${product.productid}" /> ">
			Delete </a>
		<br />
	</security:authorize>


	<%-- 	<a
		href="<spring:url value="/addShoppingCart?id=${product.productid}" /> ">
		</span> Add To Cart
	</a>
 --%>
	<a href="<spring:url value="/addToCart/${product.productid}" /> ">
		</span> Add To Cart
	</a> }
</body>
</html>