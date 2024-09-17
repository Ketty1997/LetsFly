<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@page import="com.letsfly.dto.*"%>
<%@page import="com.letsfly.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Ticket</title>
</head>
<body>
	<p>
	<h1>UPDATE OR DELETE TICKET</h1>
	</p>
	<br>
	<br>
	<f:form modelAttribute="ticketForm" method="PUT"
		action="/ticket/update">
		<f:input path="id" type="hidden" />
		<p>
			<f:label path="flight">Flight:</f:label>
			<f:input path="flight" type="number" readonly="true"/>
		</p>
		<p>
			<f:label path="user">User:</f:label>
			<f:input path="user" type="number" />
		</p>
		<p>
			<f:label path="date">Date:</f:label>
			<f:input path="date" type="localdate" readonly="true"/>
		</p>
		<p>
			<f:label path="time">Time:</f:label>
			<f:input path="time" type="time" readonly="true" />
		</p>
		
		<input type="submit" class="btn btn-primary" value="Update" />
	</f:form>
	<br>
	<br>

	<form id="deleteForm">
	  <button onclick="sendDelete('/ticket/delete', ${ticketForm.id})">Delete</button>
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