<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User</title>
</head>
<body>
	<div align="center">
		<h3>
			<a href="newContact">Add Contact</a>
		</h3>
		<h2>User List</h2>

		<table border="1">
			<th>No</th>
			<th>Name</th>
			<th>Email</th>
			<th>Address</th>
			<th>Telephone</th>
			<th>Action</th>

			<c:forEach var="contact" items="${listContact}" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${contact.name}</td>
					<td>${contact.email}</td>
					<td>${contact.address}</td>
					<td>${contact.telephone}</td>
					<td><a href="editContact?id=${contact.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a href="deleteContact?id=${contact.id}">Delete</a>
					</td>

				</tr>
			</c:forEach>			
		</table>
		
		
		
	</div>
</body>

 <!-- <script>
    $( document ).ready(function() {
        console.log( "document loaded" );
    });
 
    $( window ).on( "load", function() {
    	
        console.log( "window loaded" );
    });
    </script> -->
</html>
