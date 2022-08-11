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
		<th>Actions</th>
		<th>Delete</th>
	</tr>
	<c:forEach var="expense" items="${expenses}">
	<tr>
		<td><a href="/expenses/${expense.id}"><c:out value="${expense.getName()}"/></a></td>
		<td><c:out value="${expense.vendor}"/></td>
		<td>$<c:out value="${expense.amount}"/></td>
		<td><a href="/expenses/edit/${expense.id}">Edit</a></td>
		<td><form action="/expenses/delete/${expense.id}" method="post">
    		<input type="hidden" name="_method" value="delete">
    		<input type="submit" value="Delete">
			</form></td>
	</tr>
	</c:forEach>
</table>
<hr><br>

<form:form action="/create" method="post" modelAttribute="expense">

	<form:label path="name">Expense Name:</form:label>
		<form:input path="name" type="text"/><br>
		<form:errors path="name"/>
	<form:label path="vendor">Vendor Name:</form:label>
		<form:input path="vendor" type="text"/><br>
		<form:errors path="vendor"/>
	<form:label path="amount">Amount:</form:label>
		<form:input path="amount" type="text"/><br>
		<form:errors path="amount"/>
	<form:label path="description">Description:</form:label>
		<form:textarea path="description"/><br>
		<form:errors path="description"/>
	<button type="submit">Submit</button>
	
</form:form>

</body>
</html>