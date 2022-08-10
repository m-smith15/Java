<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test</title>
</head>
<body>
<h1> Test </h1>

<h2>Your book:</h2>
${book.id}<br>
${book.title}<br>
${book.description}<br>
${book.numberOfPages}<br>
</body>
</html>