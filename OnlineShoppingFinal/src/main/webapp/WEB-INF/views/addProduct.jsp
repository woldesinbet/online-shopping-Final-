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

	<form:form modelAttribute="newProduct" method="post"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td>Category:</td>
				<td><form:select id="assignedcategory"
						path="assignedcategory.id" items="${categories}" itemValue="id"
						itemLabel="name" /></td>
			</tr>
			<tr>
				<td>Product Name:</td>
				<td><form:input id="name" name="name" path="name" type="text" /></td>
				<td><form:errors path="name" cssStyle="color:red;" /></td>
			</tr>

			<tr>
				<td>Unit Price:</td>
				<td><form:input id="price" name="price" path="price"
						type="text" /></td>
				<td><form:errors path="price" cssStyle="color:red;" /></td>
			</tr>

			<tr>
				<td>Quantitiy: </td>
				<td><form:input id="quantitiy" name="quantitiy" path="quantitiy"
						type="number" /></td>
				<td><form:errors path="quantitiy" cssStyle="color:red;" /></td>
			</tr>

			<tr>
				<td>Description:</td>
				<td><form:textarea id="desribtion" path="desribtion" /></td>
				<td><form:errors path="desribtion" cssStyle="color:red;" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Add" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>