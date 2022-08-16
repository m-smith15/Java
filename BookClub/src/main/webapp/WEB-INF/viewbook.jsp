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
<link rel="stylesheet" href="/css/style.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>View One Book</title>
</head>
<body style="background-color: steelblue;">
	<h1>
		Take a closer look at
		<c:out value="${book.title}" />
	</h1>
	<div class="container">
	<h2>${book.user.first_name} ${book.user.last_name} read ${book.title} by ${book.author}</h2>

	<p><c:out value="${book.description}"></c:out></p>
	<form action="/book/like/${id}" method="post">
		<button type="submit">Like book?</button>
	</form>
	
	<p>(Debug) User ID -<c:out value="${user.id}"/></p>
	<p>(Debug) Book User ID -<c:out value="${book.user.id}"/></p>
	<c:if test="${user.id == book.user.id}">
		<a class="btn" style="border: solid 2px black" href="/book/edit/${id}">Edit Entry?</a>
	</c:if>
	</div>
	<hr>
	<br>
	<a class="btn" style="border: solid 2px black" href="/dashboard">Return
		to the dash?</a>
	<hr>
	<br>
	<a class="btn" style="border: solid 2px black" href="/logout">Logout?</a>
</body>
</html>