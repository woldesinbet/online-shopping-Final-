<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div>

	<form:form modelAttribute="newCustomer" method="post"
		enctype="multipart/form-data">
		

		<table>
			<tr>
				<td>First Name:</td>
				<td><form:input id="firstname" name="firstname"
						path="firstname" type="text" /></td>
				<td><form:errors path="firstname" cssStyle="color:red;" /></td>
			</tr>

			<tr>
				<td>Last Name:</td>
				<td><form:input id="lastname" name="lastname" path="lastname"
						type="text" /></td>
				<td><form:errors path="lastname" cssStyle="color:red;" /></td>
			</tr>


			<tr>
				<td>Username :</td>
				<td><form:input id="account.username" path="account.username" /></td>
				<td><form:errors path="account.username" cssStyle="color:red;" /></td>

			</tr>
			<tr>
				<td>Password :</td>
				<td><form:input id="account.password" path="account.password" /></td>
				<td><form:errors path="account.password" cssStyle="color:red;" /></td>

			</tr>

			<tr>
				<td><h3>Address Information</h3></td>
			</tr>
			<tr>
				<td>Street :</td>
				<td><form:input id="assignedAddress.Street"
						path="assignedAddress.Street" /></td>
				<td><form:errors path="assignedAddress.Street"
						cssStyle="color:red;" /></td>

			</tr>

			<tr>
				<td>City :</td>
				<td><form:input id="assignedAddress.city"
						path="assignedAddress.city" /></td>
				<td><form:errors path="assignedAddress.city"
						cssStyle="color:red;" /></td>

			</tr>
			<tr>
				<td>State :</td>
				<td><form:input id="assignedAddress.state"
						path="assignedAddress.state" /></td>
				<td><form:errors path="assignedAddress.state"
						cssStyle="color:red;" /></td>

			</tr>
			<tr>
				<td>Zip :</td>
				<td><form:input id="assignedAddress.zip"
						path="assignedAddress.zip" /></td>
				<td><form:errors path="assignedAddress.zip"
						cssStyle="color:red;" /></td>

			</tr>
			<tr>
				<td>phone :</td>
				<td><form:input id="assignedAddress.phone"
						path="assignedAddress.phone" /></td>
				<td><form:errors path="assignedAddress.phone"
						cssStyle="color:red;" /></td>

			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input id="assignedAddress.email"
						path="assignedAddress.email" /></td>
				<td><form:errors path="assignedAddress.email"
						cssStyle="color:red;" /></td>

			</tr>
		</table>
		<form:hidden path="account.enabled" value="true"/>
		<input type="submit" value="SignUp">
	</form:form>
</div>


