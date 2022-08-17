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
<title>single prod</title>
</head>
<body style="background-color: steelblue">
	<h1>find yer soulmate at singleproduct.thispage</h1>

	<h3>Categories</h3>
	<c:forEach var="item" items="${product.getCategories()}">
		<li>${name}</li>
		<li>${item.name}</li>
	</c:forEach>

	<h3>Add Category</h3>
	<form:form action="/product/${id}/add" method="post" modelAttribute="category">
		<form:select path="id">
			<c:forEach var="item" items="${categories}">
				<form:option value="${item.id}" path="id">
					<c:out value="${item.name}" />
				</form:option>
			</c:forEach>
		</form:select>
		<button type="submit">Add it!</button>
	</form:form>

</body>
</html>