<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test all books</title>
</head>
<body>
<h1> Test?! </h1>

<c:forEach var="book" items="${books}">
	<div>
		<p>${book.id }</p>
		<p><a href="/books/${book.id}">${book.title }</a></p>
		<p>${book.language }</p>
		<p>${book.numberOfPages }</p>
	</div>
</c:forEach>
</body>
</html>