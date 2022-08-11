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
    <title>Just look at these Expenses</title>
</head>
<body>
<h1> Just look at this page render!</h1>

<table>
	<tr>
		<th>Expense</th>
		<th>Vendor</th>
		<th>Amount</th>
	</tr>
	<c:forEach var="expense" items="${expenses}">
	<tr>
		<td><c:out value="${expense.getName()}"/></td>
		<td><c:out value="${expense.vendor}"/></td>
		<td>${expense.amount}</td>
	</tr>
	</c:forEach>
</table>
<hr><br>

<form:form action="/create" method="post" modelAttribute="expense">

	<form:label path="name">Expense Name:</form:label>
		<form:input path="name" type="text"/><br>
	<form:label path="vendor">Vendor Name:</form:label>
		<form:input path="vendor" type="text"/><br>
	<form:label path="amount">Amount:</form:label>
		<form:input path="amount" type="text"/><br>
	<form:label path="description">Description:</form:label>
		<form:textarea path="description"/><br>
	<button type="submit">Submit</button>
	
</form:form>

</body>
</html>