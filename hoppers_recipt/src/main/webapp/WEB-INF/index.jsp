<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Look at this title</title>
</head>
<body>
<h1> Just look at these results</h1>
	<p><c:out value="${name}"></c:out></p>
	<p><c:out value="${itemName}"></c:out></p>
	<p><c:out value="${price}"></c:out></p>
	<p><c:out value="${description}"></c:out></p>
	<p><c:out value="${vendor}"></c:out></p>

</body>
</html>