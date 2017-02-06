<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
<title>Insert title here</title>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js">
	
</script>
<script>
	function remove(event) {
		var productId = $(event.target).attr('data-productId');
		var cartId = $(event.target).attr('data-cartId');
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");

		if (confirm("Are you sure you want to remove this item(" + productId
				+ " for cart " + cartId + ")? ")) {
			var data = {
				'productId' : productId,
				'cartId' : cartId
			};
			$
					.ajax({
						type : "POST",
						url : "/cart/remove",
						data : data,
						timeout : 7000,
						beforeSend : function(xhr) {
							xhr.setRequestHeader(header, token);
						},
						success : function(data) {
							alert("Succesfully removed: "
									+ $(event.target).data("id"));
							$(event.target).closest('tr').remove();
						},
						error : function(xhr, textStatus, errorThrown) {
							alert(errorThrown);
						}
					});

		}
		return false;
	}
</script>
</head>

<body>
	<h2>Shopping Cart List</h2>
	<table>
		<tr>
			<th>Product Name</th>
			<th>Unit Price</th>
			<th>Quantity Ordered</th>
			<th>Total Price</th>
			<th>Remove</th>
		</tr>
		<!-- List of cart items -->
		<c:forEach var="cItem" items="${cart.cartItems}">
			<tr>
				<td>${cItem.product.name}</td>
				<td>${cItem.product.price}</td>
				<td>${cItem.quantity}</td>
				<td>${cItem.totalPrice}</td>
				<td><button data-productId="${cItem.product.productid}"
						data-cartId="${cart.id}" onclick=" return remove(event)"
						class="remove">Remove</button></td>
			</tr>

		</c:forEach>
	</table>

	<br /> Total: ${cart.totalPrice}
	<br />

	<a href="<spring:url value="/viewproducts" /> "> Keep Shopping </a>
	<br />
	<a href="<spring:url value="/checkout" /> "> CheckOut </a>
	<br />
</body>
</html>