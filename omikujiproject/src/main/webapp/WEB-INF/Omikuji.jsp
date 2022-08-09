<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Check out this Omikuji</title>
</head>
<body>
<h1>Check our this Omikuji just fer yew!</h1>

<div><span>In <c:out value="${years}"/> you will live in <c:out value="${city}"/> with <c:out value="${person}"/> as a roommate, doing <c:out value="${hobby}"/> as a hobby. Keep close watch for <c:out value="${creature}"/> the next time you see one you'll have great luck. Also, you should know: <c:out value="${nice}"/></span>
</div>
</body>
</html>