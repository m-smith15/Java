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
<meta charset="ISO-8859-1">
<title>Add a ninja!</title>
</head>
<body>
<h1>Thanks for not leaving. You wouldn't close out the tab...would you?</h1>

<form:form action="/ninja/create" method="post" modelAttribute="ninja">

	<form:label path="first_name">First name:</form:label>
	<form:input type="text" path="first_name"/>
	<form:errors path="first_name"/>
	<form:label path="last_name">Last name:</form:label>
	<form:input type="text" path="last_name"/>
	<form:errors path="last_name"/>
	<form:label path="age">Age:</form:label>
	<form:input type="text" path="age"/>
	<form:errors path="age"/>
    <form:select path="dojo">
        <c:forEach var="location" items="${dojos}">
            <form:option value="${location.id}" path="dojo">
                <c:out value="${location.name}"/>
            </form:option>
        </c:forEach>
    </form:select>
	
	<button type="submit">Enroll</button>
</form:form>



<h1>${dojos}</h1>
<h1>hurr durr</h1>



</body>
</html>