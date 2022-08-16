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
<title>Edit this book</title>
</head>
<body style="background-color: steelblue;">
<h1>Edit this book</h1>

	<form:form action="/book/edit/${id}" method="post" modelAttribute="book">
		<input type="hidden" name="_method" value="put"/>
		<form:label path="title">title:</form:label>
		<form:input path="title" type="text" value="${book.title}" />
		<form:errors path="title" />
		<br>
		<form:label path="author">author:</form:label>
		<form:input path="author" type="text" value="${book.author}" />
		<form:errors path="author" />
		<br>
		<form:label path="description">description:</form:label>
		<form:textarea path="description" value="${book.description }" />
		<form:errors path="description" />
		<br>
		<form:input type="hidden" path="user" value="${book.getUser().getId()}"/>
		<button type="submit">Edit!</button>
	</form:form>

</body>
</html>