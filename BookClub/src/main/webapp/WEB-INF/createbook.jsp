<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Create Book</title>
</head>
<body style="background-color: steelblue;">
	<h1>So, <c:out value="${first_name}"/> <c:out value="${last_name}"/> with an ID of <c:out value="${id}"/> wants to create a book eh?</h1>

	<form:form action="/book/create/new" method="post" modelAttribute="book">
		<form:label path="title">title:</form:label>
		<form:input path="title" type="text" />
		<form:errors path="title" />
		<br>
		<form:label path="author">author:</form:label>
		<form:input path="author" type="text" />
		<form:errors path="author" />
		<br>
		 <form:input type="hidden" path="user" value="${id}"/>
		<button type="submit">Create!</button>
	</form:form>

	<hr>
	<br>
	<a class="btn" style="border: solid 2px black" href="/dashboard">Return
		to the dash?</a>
	<hr>
	<br>
	<a class="btn" style="border: solid 2px black" href="/logout">Logout?</a>
</body>
</html>