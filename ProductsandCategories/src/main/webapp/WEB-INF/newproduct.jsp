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
<title>new prod</title>
</head>
<body style="background-color:steelblue">
<h1> peep this new prod page</h1>

<form:form action="/product/new/create" method="post" modelAttribute="product">
	<form:label path="name">Name</form:label>
	<form:input path="name" type="text" />
	<form:errors path="name" /> <br>
	<form:label path="description">Description</form:label>
	<form:input path="description" type="text" />
	<form:errors path="description" /> <br>
		<form:label path="price">Price</form:label>
	<form:input path="price" type="text" />
	<form:errors path="price" /> <br>
	<button type="submit">Create!</button>
</form:form>


</body>
</html>