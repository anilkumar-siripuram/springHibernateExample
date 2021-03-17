<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Employee Registration Form</title>
<link href="<c:url value="/resources/css/registration.css" />" rel="stylesheet">
<style>

	.error {
		color: #ff0000;
	}
</style>

</head>

<body>

	<h2>Registration Form</h2>
 
	<form:form method="POST" modelAttribute="employee">
		<form:input type="hidden" path="id" id="id"/>
		<div class="">
		<table width="100%">
			<tr>
				<td><label for="name">Name: </label> </td>
				<td><form:input path="name" id="name"/></td>
				<td><form:errors path="name" cssClass="error"/></td>
		    </tr>
	    
			<tr>
				<td><label for="joiningDate">Joining Date: </label> </td>
				<td><form:input path="joiningDate" id="joiningDate"/></td>
				<td><form:errors path="joiningDate" cssClass="error"/></td>
		    </tr>
	
			<tr>
				<td><label for="salary">Salary: </label> </td>
				<td><form:input path="salary" id="salary"/></td>
				<td><form:errors path="salary" cssClass="error"/></td>
		    </tr>
	
			<tr>
				<td><label for="ssn">SSN: </label> </td>
				<td><form:input path="ssn" id="ssn"/></td>
				<td><form:errors path="ssn" cssClass="error"/></td>
		    </tr>
		    
		    <tr>
				<td><label for = "gender">Gender</label></td>
		               <td>
		                  <form:radiobutton path = "gender" value = "M" label = "Male" />
		                  <form:radiobutton path = "gender" value = "F" label = "Female" />
		               </td>
		               <td><form:errors path="gender" cssClass="error"/></td>
			</tr>
		    
		   <%--  <tr>
				<td><label for="ssn">Gender: </label> </td>
				<td><form:input path="gender" id="gender"/></td>
				<td><form:errors path="gender" cssClass="error"/></td>
		    </tr> --%>
	
			
	
			<tr>
				<td colspan="3">
					<c:choose>
						<c:when test="${edit}">  <!-- if this edit is true then we will update -->
							<input type="submit" value="Update"/>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Register"/>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</table>
		</div>
	</form:form>
	<br/>
	<br/>
	Go back to <a href="<c:url value='/list' />">List of All Employees</a>
</body>
</html>