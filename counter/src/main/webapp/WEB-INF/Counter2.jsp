<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>You've visited <c:out value="${count}"/> times</h1>

<a href="/">Go back to the homepage??</a> <br>
<hr>
<a href="/reset">Wanna reset your count(s)?</a>

</body>
</html>