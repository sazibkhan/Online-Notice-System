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

<link href="css/style.css" rel='stylesheet' type='text/css' />
<spring:url value="/static/css/userLogin.css" var="userLogin" />
<spring:url value="/static/css/font-awesome.min.css" var="font-awesome.min" />

<link href="${font-awesome.min}" rel="stylesheet" />
<link href="${userLogin}" rel="stylesheet" />


<link href="//fonts.googleapis.com/css?family=Signika:300,400,700" rel="stylesheet" />
<link href="//fonts.googleapis.com/css?family=Roboto+Condensed:400,700" rel="stylesheet" />
            <form:form id="regForm" modelAttribute="user" action="registerProcess" method="post">
              
		<div class="main-grid">
			<div class="agile-grids">	
				
				<div class="grids">
					
					
					<div class="forms-grids">
						<div class="forms3">
						<div class="w3agile-validation w3ls-validation">
							<div class="panel panel-widget agile-validation register-form" style="margin-left: 25%; margin-top: 5%;" >
								<div class="validation-grids widget-shadow" data-example-id="basic-forms" style="width: 45.5%; float: left; margin-left: 26%; ma background: none" > 
									
									<div class="form-body form-body-info">
										
											<div class=" valid-form" >
											 <span class="help-block">User Name</span>
												 <form:input path="username" name="username" id="name" />
											</div>
											
											<div class=" valid-form">
												<span class="help-block">Password </span>
												<form:password path="password" name="password" id="name" />
											</div>
											
											<div class=" valid-form">
												 <span class="help-block">First Name</span>
												<form:input path="firstname" name="firstname" id="name" />
												
											</div>
											
											<div class="valid-form">
											<span class="help-block">Last name</span>
											  <form:input path="lastname" name="lastname" id="name" />
											</div>
											<div class="valid-form">
											<span class="help-block">Address</span>
											  <form:input path="address" name="lastname" id="name" />
											</div>
											
											<div class="valid-form">
											<span class="help-block">Phone</span>
											  <form:input path="phone" name="phone" id="name" />
											 
											</div>
										<div class="help-block">
											<div class="radio" id="name">
												<form:label path="gender">Gender</form:label>
												<form:radiobutton path="gender" value="male" label="Male" />
												<form:radiobutton path="gender" value="male" label="Female" />
											</div>
										</div>

										<div>
												<form:button id="register" name="register"  class="button">Register</form:button>
											</div>
											
											<div class="clearfix"> 
												
													</div>
									
									</div>
								</div>
							</div>
							</div>
							</div>
							</div>
							</div>
							</div>
							</div>
            </form:form>
        </body>

</html>