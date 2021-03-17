<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Spring MVC PDF View Example</title>
</head>

<body>
	<h3>List of Employees</h3>
	<form:form  action="/SpringHibernateExample/generatePDF" method="get" modelAttribute="employee">
	<table>
		<tr>
			<td> NAME</td>
			<td>Joining Date</td>
			<td>Salary</td>
			<td>SSN</td>
			
		</tr>
		<c:forEach items="${employees}" var="employee">
			<tr>
				<td>${employee.name}</td>
				<td>${employee.joiningDate}</td>
				<td>${employee.salary}</td>
				<td>${employee.ssn}</a></td>
				
			</tr>
		</c:forEach>
	</table>
	</form:form>

</html>