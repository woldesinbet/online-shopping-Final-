<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
</head>

<body>
	<h2>Shopping Cart List</h2>
	<table>

		<tr>
			<th>Product Name</th>
			<th>Price</th>
			<th></th>
		</tr>
		<c:set var="total" value="${0}" />
		<c:forEach items="${cartList}" var="cartList">

		<tr><td><a
		href="<spring:url value="/removeCartItems?id=${cartList.id}" /> ">
	 	Remove Cart
		</a></td></tr>
			<c:forEach items="${cartList.holdsproducts}" var="products">

				<tr>
					<td>${products.name }</td>
					<td>${products.price }</td>
					
				</tr>
				<c:set var="total" value="${total + products.price}" />

			</c:forEach>
		
		</c:forEach>
		<tr></tr>
		<tr>
			<td><b>Total Price: </td>
			<td>${ total} </b></td>
		</tr>
	</table>
	<a href="<spring:url value="viewproducts" /> ">  Keep Shopping </a>
	<br />
	<a href="<spring:url value="/checkout" /> ">  CheckOut </a>
	<br />
	
</body>
</html>