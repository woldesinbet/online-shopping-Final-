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

</head>
<body>
	
<h1> Available Category  </h1>
<c:forEach items="${category}" var="category">
		<div
			style="border: 2px solid blue; width: 300px; float: left; margin: 5px">
			<p> Name: ${category.name }</p>
			<p>Description: ${category.description }</p>
			<br /> 		</div>
	</c:forEach>
	<body>




</body>
</html>