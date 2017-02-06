<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<sec:authorize access="isAuthenticated()">
	<%
		response.sendRedirect("/home");
	%>
</sec:authorize>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<H1> Welcome To Online Shopping </H1>
	<h2>Login Page</h2>

	<form action="<c:url value="/login"></c:url>" method="post">
		User: <input type="text" name="username" id="username" /> <br />
		Password: <input type="password" name="password" id="password" /> <br />
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" /> <input type="submit" />
		</li>
	</form>
	<br />
	<a href='<spring:url value="/signUp" />'>Sign Up If You are new! </a>
	
	

</body>
</html>