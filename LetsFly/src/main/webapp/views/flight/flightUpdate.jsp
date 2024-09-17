<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@page import="com.letsfly.dto.*"%>
<%@page import="com.letsfly.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Flight</title>
</head>
<body>
	<p>
	<h1>DELETE FLIGHT</h1>
	</p>
	<br>
	<br>
	<f:form modelAttribute="flightForm" method="PUT"
		action="/flight/update">
		<f:input path="id" type="hidden" />
		<p>
			<f:label path="route">Route:</f:label>
			<f:input path="route" type="number" readonly="true" />
		</p>
		<p>
			<f:label path="dateDeparture">Date of Departure:</f:label>
			<f:input path="dateDeparture" type="date" readonly="true" />
		</p>
		<p>
			<f:label path="timeDeparture">Time of Departure:</f:label>
			<f:input path="timeDeparture" type="time" readonly="true" />
		</p>
		<p>
			<f:label path="dateArrival">Date of Arrival:</f:label>
			<f:input path="dateArrival" type="date" readonly="true" />
		</p>
		<p>
			<f:label path="timeArrival">Time of Arrival:</f:label>
			<f:input path="timeArrival" type="time" readonly="true" />
		</p>
	</f:form>
	<br>
	<br>

	<form id="deleteForm">
	  <button onclick="sendDelete('/flight/delete', ${flightForm.id})">Delete</button>
	</form>

</body>
<script>
	function sendDelete(url, id) {
		var form = document.getElementById("deleteForm");
		form.action = url+"/"+id
		form.method = "DELETE";

		form.submit();
	}
</script>
</html>