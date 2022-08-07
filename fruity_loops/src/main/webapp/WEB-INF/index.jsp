<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/style.css"/>

<title>Theses loops are fruuuuuuuity!</title>
</head>
<body>
    <h1>Fruits to sell</h1>
    <div class="container">
    <c:forEach var="fruit" items="${fruitsToDisplay}">
        <p><c:out value="${fruit.getName()} ${fruit.getPrice()}"></c:out></p>
    </c:forEach>
    </div>
</body>
</html>