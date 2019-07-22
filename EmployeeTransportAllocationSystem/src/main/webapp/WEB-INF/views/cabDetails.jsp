<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cab Details</title>

<style>
.blue-button {
	background: #25A6E1;
	filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#25A6E1',
		endColorstr='#188BC0', GradientType=0);
	padding: 3px 5px;
	color: #fff;
	font-family: 'Helvetica Neue', sans-serif;
	font-size: 12px;
	border-radius: 2px;
	-moz-border-radius: 2px;
	-webkit-border-radius: 4px;
	border: 1px solid #1A87B9
}

table {
	font-family: "Helvetica Neue", Helvetica, sans-serif;
	width: 50%;
}

th {
	background: SteelBlue;
	color: white;
}

td, th {
	border: 1px solid gray;
	width: 25%;
	text-align: left;
	padding: 5px 10px;
}
</style>



</head>
<body>
	<form:form method="post" modelAttribute="cab"
		action="/EmployeeTransportAllocationSystem/addCab">
		<table>
			<tr>
				<th colspan="2">Add Cab</th>
			</tr>
			<tr>
				<form:hidden path="cabId" />
				<td><form:label path="registrationNumber">Registration Number:</form:label></td>
				<td><form:input path="registrationNumber" size="30"
						maxlength="30"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="driverId">Driver ID:</form:label></td>
				<td><form:input path="driverId" size="30" maxlength="30"></form:input></td>
			</tr>
			<td><form:label path="cabStatus">Cab Status</form:label></td>
			<td><form:input path="cabStatus" size="1" maxlength="1"></form:input></td>
			</tr>
			<tr>
				<td><form:label path="comments">Comments</form:label></td>
				<td><form:input path="comments" size="100" maxlength="100"></form:input></td>
			</tr>
			<td><form:label path="vacancy">Vacancy</form:label></td>
			<td><form:input path="vacancy" size="10" maxlength="10"></form:input></td>
			</tr>
			<td colspan="2"><input type="submit" class="blue-button" /></td>
			</tr>
		</table>
	</form:form>
	</br>
	<h3>Employee List</h3>
	<c:if test="${!empty listOfCabs}">
		<table class="tg">
			<tr>
				<th width="80">Cab Id</th>
				<th width="120">Registration Number</th>
				<th width="120">Driver Id</th>
				<th width="120">Cab Status</th>
				<th width="120">Comments</th>
				<th width="120">Vacancy</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
				<th width="60">Make Available</th>
				<th width="60">Make Unavailable</th>
			</tr>
			<c:forEach items="${listOfCabs}" var="cab">
				<tr>
					<td>${cab.cabId}</td>
					<td>${cab.registrationNumber}</td>
					<td>${cab.driverId}</td>
					<td>${cab.cabStatus}</td>
					<td>${cab.comments}</td>
					<td>${cab.vacancy}</td>

					<td><a href="<c:url value='/updateCab/${cab.cabId}' />">Edit</a></td>
					<td><a href="<c:url value='/deleteCab/${cab.cabId}' />">Delete</a></td>
					<td><a href="<c:url value='/setCabStatusToAvailable/${cab.cabId}' />">Available</a></td>
					<td><a href="<c:url value='/setCabStatusToUnavailable/${cab.cabId}' />">Unavailable</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>