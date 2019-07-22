<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking Status</title>

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
	<form:form method="post" modelAttribute="bookingrequeststatus"
		action="/EmployeeTransportAllocationSystem/getRequestStatusOfBooking">
		<table>
			<tr>
				<th colspan="2">Check Request Status</th>
			</tr>
			<tr>
				<form:hidden path="id" />
				<td><form:label path="id">Request Id</form:label></td>
				<td><form:input path="id" size="30" maxlength="30"></form:input></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" class="blue-button" /></td>
			</tr>
		</table>
	</form:form>
	<c:if test="${!empty ERROR_CODE }">
		<c:out value="${ERROR_CODE }"></c:out>
	</c:if>

	<h1>${result}</h1>
	<h3>Booking List</h3>
	<c:if test="${!empty listOfBookingRequestStatus}">
		<table class="tg">
			<tr>
				<th width="80">Request Id</th>
				<th width="120">Booking Status OF Journey</th>
				<th width="120">Comments</th>
				<th width="120">Source Location</th>
				<th width="120">Date Time Of Journey</th>
				<th width="60">Cancel</th>
			</tr>
			<c:forEach items="${listOfBookingRequestStatus}"
				var="bookingrequeststatus">
				<tr>
					<td>${bookingrequeststatus.id}</td>
					<td>${bookingrequeststatus.requestStatus}</td>
					<td>${bookingrequeststatus.comments}</td>
					<td>${bookingrequeststatus.sourceLocation}</td>
					<td>${bookingrequeststatus.dateTimeOfJourney}</td>
					<td><a
						href="<c:url value='/cancelBooking/${bookingrequeststatus.id}' />">Cancel</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>