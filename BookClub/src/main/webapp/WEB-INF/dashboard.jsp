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
	<title>THE DASH</title>
</head>
<body style="background-color:steelblue;">
<h1>Welcome <c:out value="${first_name}"/> <c:out value="${last_name}"/></h1>
<h1>Your ID is <c:out value="${id}"/>  and your email is <c:out value="${email}"/> </h1>

<table style="background-color:seagreen;">
	<tr>
		<th>ID</th>
		<th>Title</th>
		<th>Author</th>
		<th>Posted By</th>
	</tr>
	<c:forEach var="book" items="${books}">
		<tr>
			<td>${book.id} |</td>
			<td><a href="/book/view/${book.id}">${book.title }</a> |</td>
			<td>${book.author } |</td>
			<td>${book.user.first_name} ${book.user.last_name}</td>
		</tr>
	</c:forEach>
</table>
<div><h4>testing likes</h4>
<p><c:forEach var="like" items="${user.bookLikes}">
<c:out value="${like.title}"/>
</c:forEach></p>

</div>
<hr><br>
<a class="btn" style="border:solid 2px black" href="/book/create">Create Book?</a>
<hr><br>
<a class="btn" style="border:solid 2px black" href="/logout">Logout?</a>
</body>
</html>