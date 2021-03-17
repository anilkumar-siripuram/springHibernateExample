<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/submitData" method="POST">
<h1>${msg1}</h1>
<h3>welcome to RegistrationForm</h3>
student id : <input type = "text" value="studentid"> <br><br>
student name : : <input type = "text" value="studentName"> <br>
<input type="submit" value="Register">
</form>


</body>
</html>