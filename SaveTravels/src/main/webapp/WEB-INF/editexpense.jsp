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
<title>Edit this here expense</title>
</head>
<body>
<h1>${editExpense}</h1>
<h1>${editExpense.getName()}</h1>
<h1>${name}</h1>

<form:form action="/edit/${editExpense.id}" method="POST" modelAttribute="editExpense">
	<input type="hidden" name="_method" value="put">
	<form:label path="name">Expense Name:</form:label>
		<form:input path="name" type="text"/>
		<form:errors path="name"/><br>
	<form:label path="vendor">Vendor Name:</form:label>
		<form:input path="vendor" type="text"/>
		<form:errors path="vendor"/><br>
	<form:label path="amount">Amount:</form:label>
		<form:input path="amount" type="text"/>
		<form:errors path="amount"/><br>
	<form:label path="description">Description:</form:label>
		<form:textarea path="description"/>
		<form:errors path="description"/><br>
	<button type="submit">Submit</button>
	
</form:form>


</body>
</html>