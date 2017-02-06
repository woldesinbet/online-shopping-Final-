<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users</title>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
	<h2>
		<b> Customers List </b>
	</h2>
	<div>
		<table>

			<c:forEach items="${users}" var="user">
				<div
					style="border: 5px solid blue; height: 350px; width: 300px; float: left; margin: 15px">
					<p>Name: ${user.firstname} ${user.lastname}</p>

					<p>
						<b>Contact Detail </b>
					</p>
					<br />

					<p>Address:</p>
					<p>${user.assignedAddress.street}
					<p>
					<p>${user.assignedAddress.city},${user.assignedAddress.state}
						${user.assignedAddress.zip}</p>
					<br />
					<p>Email: ${user.assignedAddress.email}</p>
					<a href="<spring:url value="/deleteCustomer/${user.id}" /> "> </span>
						Delete
					</a>
				</div>

			</c:forEach>
		</table>
	</div>
</body>
</html>