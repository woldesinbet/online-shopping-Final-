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
<body>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

	
	</a>


	<form:form modelAttribute="newCategory" method="post"
		enctype="multipart/form-data">
		<table>

			<tr>
				<td>Category Name:</td>
				<td><form:input id="name" name="name" path="name" type="text" /></td>
				<td><form:errors path="name" cssStyle="color:red;" /></td>
			</tr>


			<tr>
				<td>Description:</td>
				<td><form:textarea id="description" path="description" /></td>
				<td><form:errors path="description" cssStyle="color:red;" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Add" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>