<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Send an Omikuji</title>
</head>
<body>
<h1>Omikuji-a-rama</h1>

<form action="/create/omikuji" method="POST">
	<label for="years">Enter a number 0-25</label>
	<input type="text" name="years"><br>
	<label for="city">Enter a city name</label>
	<input type="text" name="city"><br>
	<label for="person">Enter the name of any real person</label>
	<input type="text" name="person"><br>
	<label for="hobby">Enter a profession or hobby</label>
	<input type="text" name="hobby"><br>
	<label for="creature">Enter any living thing</label>
	<input type="text" name="creature"><br>
	<label for="nice">Enter something nice</label>
	<textarea name="nice"></textarea>
	<button type="submit">Submit</button>
</form>
</body>
</html>