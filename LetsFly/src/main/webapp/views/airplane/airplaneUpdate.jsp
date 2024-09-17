<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@page import="com.letsfly.dto.*"%>
<%@page import="com.letsfly.model.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Airplane</title>
</head>

<body>
	<p>
	<h1>UPDATE OR DELETE AIRPLANE</h1>
	</p>
	<br>
	<br>
	<f:form modelAttribute="airplaneForm" method="PUT"
		action="/airplane/update">
		<f:input path="id" type="hidden" />
		<p>
			<f:label path="seatRow">Seat Rows:</f:label>
			<f:input path="seatRow" type="number" />
		</p>
		<p>
			<f:label path="seatColumn">Seat Columns:</f:label>
			<f:input path="seatColumn" type="number" />
		</p>
		<input type="submit" class="btn btn-primary" value="UPDATE" />
	</f:form>
	<br>
	<br>

	<form id="deleteForm">
	  <button onclick="sendDelete('/airplane/delete', ${airplaneForm.id})">Delete</button>
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