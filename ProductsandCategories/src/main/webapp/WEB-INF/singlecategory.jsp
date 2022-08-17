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
<title>single category</title>
</head>
<body style="background-color:steelblue">
<h1>find yer soulmate at singlecategory.thispage</h1>

<h3>Products</h3>
<c:forEach var="item" items="${category.getProducts()}">
<li>${name}</li>
<li>${item.name}</li>
</c:forEach>


	<h3>Add Product</h3>
	<form:form action="/category/${id}/add" method="post" modelAttribute="product">
	<input type="hidden" name="_method" value="put"/>
	<form:select path="id">
		<c:forEach var="item" items="${products}">
			<form:option value="${item.id}" path="id">
				<c:out value="${item.name}" />
			</form:option>
		</c:forEach>
	</form:select>
	<button type="submit">Add it!</button>
	</form:form>

</body>
</html>