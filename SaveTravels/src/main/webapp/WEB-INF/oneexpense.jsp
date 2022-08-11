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
<title>Take a gander at this expense</title>
</head>
<body>
<h1> Expense Details</h1>
<hr>
<p>Expense Name: ${viewExpense.getName()}</p>
<p>Expense Description: ${viewExpense.getDescription()}</p>
<p>Expense Vendor: ${viewExpense.getVendor()}</p>
<p>Expense Amount: ${viewExpense.getAmount()}</p>
<hr> <br>
<a href="/">Go back</a>
</body>
</html>