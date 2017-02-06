<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">

<!-- If IE use the latest rendering engine -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!-- Set the page to the width of the device and set the zoon level -->
<meta name="viewport" content="width = device-width, initial-scale = 1">
<title>Lealem Online shopping </title>
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
	<nav class="navba navbar-inverse" rolr="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-WDM-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>

			<a class="navbar-brand" href="#">Online Shopping </a>
		</div>
		<div class="collapse navbar-collapse" id="bs-WDM-navbar-collapse-1">
			<ul class="nav navbar-nav">
			
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Home<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="<spring:url value="/aboutUs" />">About
								us</a></li>

						<li><a
							href="https://www.google.com/maps/place/1000+N+4th+St,+Fairfield,+IA+52557/@41.0177712,-91.9680141,17z/data=!4m5!3m4!1s0x87e666749f98ef33:0x8cb24e40e131116b!8m2!3d41.017765!4d-91.9672901!6m1!1e1?hl=en">Location
						</a></li>
					</ul></li>
					
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"> User <span class="caret"></span></a>
					<ul class="dropdown-menu">
					
						<li><a href="<spring:url value="/signUp" />">Sign Up </a></li>
						<li><a href="<spring:url value="/viewcategory" /> ">View category </a></li>
						<li><a href="<spring:url value="/viewproducts" /> ">View product </a></li>
						<!-- <li><a href="mobile.html">Search product </a></li> -->

					</ul></li>
				
			</ul>
		</div>
	</nav>
<body>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

	
	</a>


</body>
</html>