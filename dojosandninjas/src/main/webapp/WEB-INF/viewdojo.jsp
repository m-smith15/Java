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
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Here are the ninjas for the ${dojo.name} dojo</h1>


	<table>
		<tr>
			<th>First_Name:</th>
			<th>Last_Name:</th>
			<th>Age:</th>
		</tr>
		<c:forEach var="ninja" items="${dojo.getNinjas()}">
			<tr>
				<td><c:out value="${ninja.getFirst_name()}"/> </td>
				<td><c:out value="${ninja.getLast_name()}"/></td>
				<td><c:out value="${ninja.getAge()}"/></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>