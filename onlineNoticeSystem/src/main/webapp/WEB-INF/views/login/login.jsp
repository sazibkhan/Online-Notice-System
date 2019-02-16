<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Registration / Login form template Responsive, Login form web template,Flat Pricing tables,Flat Drop downs  Sign up Web Templates, Flat Web Templates, Login sign up Responsive web template, SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

<head>
<spring:url value="/static/css/userLogin.css" var="userLogin" />
<spring:url value="/static/css/font-awesome.min.css" var="font-awesome.min" />

<link href="${font-awesome.min}" rel="stylesheet" />
<link href="${userLogin}" rel="stylesheet" />


<link href="//fonts.googleapis.com/css?family=Signika:300,400,700" rel="stylesheet" />
<link href="//fonts.googleapis.com/css?family=Roboto+Condensed:400,700" rel="stylesheet" />
</head>

<form:form action="login" method="post" modelAttribute="action"
	id="from">
	<div class="panel panel-widget agile-validation"
		style="min-height: 100%">
		<div class="drop_bar">
			<div style="float: right; margin: -9% 30px;">

				<div class="dropdown">
					<form:button class="dropbtn">Admin</form:button>
					<div class="dropdown-content">
						<a href="index">Login</a> 
						<a href="adminindex">Registration</a>
					</div>
				</div>
			</div>

		</div>
		<center>
			<div class="validation-grids"
				style="margin-top: 10%; width: 400px; margin-left: 450">
				<div class="widget-shadow login-form-shadow"
					data-example-id="basic-forms">
					<div class="input-info">
						<h3>User Login</h3>
					</div>
					<div class="form-body form-body-info">

						<div class="form-group has-feedback">
							<form:input path="username" id="name" placeholder="enter your user name" />
							<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
						</div>
						<div class="form-group">
							<form:input path="password" id="name" placeholder="enter your valid password"/>
						</div>
						<div class="bottom">
							<div class="form-group"></div>
							<div class="form-group" style="margin-left: 10%">
								<input type="submit" value="login" class="button" style="margin: 4% 20% 0% 0%"/>
							</div>
							<table align="center">
								<tr>
									<td style="font-style: italic; color: red;">${message}</td>
								</tr>
							</table>
							<div style="float: right">
								<a href="register" style="color: white">Sing Up</a>
							</div>
						</div>

					</div>
				</div>
			</div>
		</center>

	</div>
</form:form>


</html>