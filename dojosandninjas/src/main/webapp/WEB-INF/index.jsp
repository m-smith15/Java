<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <title>home page</title>
</head>
<body>
<h1>Its alive!!</h1>

<h2>Here are some dojos -</h2>
<hr><br>
<table class="container">
	<tr>
		<th>ID</th>
		<th>Name</th>
	<tr>
	<tbody>
	<c:forEach var="dojo" items="${dojos}">
		<tr>
			<td>${dojo.name}</td>
			<td><a href="/dojo/${dojo.id}">See Ninjas</a></td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<br>
<hr>
<a href="/dojo/create">Create Dojo?</a>
<br><hr>
<a href="/ninja/create">Add a Ninja?! Please don't leave!</a>   
</body>
</html>
