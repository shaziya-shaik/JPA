<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Success</h1>
	 <p>${alien}</p>
	 <br><br>
	 <h1>Get Alien</h1>
	 
	 <form action="/getAlien" method="get">
	<input type="text" name="id"><br><br>
	<input type="submit"><br>
	</form>
	 <h1>delete Alien</h1>
	<form action="/deleteAlien" method="get">
	<input type="text" name="id"><br><br>
	<input type="submit"><br>
	</form>
	
	
</body>
</html>