<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

<style>
.error {
	color: #ff0000;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form method="POST" modelAttribute="student">

		<table width="100%">
			<tr>
				<td><label for="studentName">StudentName: </label></td>
				<td><form:input path="studentName" id="studentName" /></td>
				<td><form:errors path="studentName" cssClass="error" /></td>
			</tr>

			 <tr>
				<td><label for="country">Country</label></td>
				<td><form:select path="country">
						<c:forEach items="${countryList}" var="countryList">
							<option id="${countryList.id}" value="${countryList.id}">${countryList.name}</option>
							
						</c:forEach>
					</form:select></td>
				<td><form:errors path="country" cssClass="error" /></td>
			</tr> 

			<%-- <tr>
				<td><label for="state">state</label></td>
				<td><form:select path="state">
						<form:options items="${stateList}" />
					</form:select></td>
				<td><form:errors path="country" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="city">City</label></td>
				<td><form:select path="city">
						<form:options items="${cityList}" />
					</form:select></td>
				<td><form:errors path="city" cssClass="error" /></td>
			</tr> --%>

		</table>

	</form:form>


</body>
</html>