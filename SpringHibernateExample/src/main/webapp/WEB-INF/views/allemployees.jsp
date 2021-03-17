<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>University Enrollments</title>

 <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
</head>


<body>
	<h3>List of Employees</h3>
	<table width="80%">
		<tr>
			<td width="15%">NAME</td>
			<td width="20%">Joining Date</td>
			<td width="20%">Salary</td>
			<td width="10%">Gender</td>
			<td width="15%">SSN</td>
			
			<td></td>
		</tr>
		<c:forEach items="${employees}" var="employee">
			<tr>
				<td>${employee.name}</td>
				<td>${employee.joiningDate}</td>
				<td>${employee.salary}</td>
				<td>${employee.gender}</td>
				<td><a href="<c:url value='/edit-${employee.ssn}-employee' />">${employee.ssn}</a></td>
				<td><a
					href="<c:url value='/delete-${employee.ssn}-employee' />">delete</a></td>
				
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="<c:url value='/new' />">Add New Employee</a> <br>
	<spring:url value="/list/?type=xls" var="xlsURL" /> 
 <spring:url value="/list/?type=pdf" var="pdfURL" /> <br>
 <a href="${xlsURL }">Download Excel</a> <br>
 <a href="${pdfURL }">Download PDF</a>
</body>

</html>