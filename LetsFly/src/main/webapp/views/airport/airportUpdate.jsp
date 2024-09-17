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
<title>View Airport</title>
</head>
<body>
	<p>
	<h1>UPDATE OR DELETE AIRPORT</h1>
	</p>
	<br>
	<br>
	<f:form modelAttribute="airportForm" method="PUT"
		action="/airport/update">
		<f:input path="id" type="hidden" />
		<p>
			<f:label path="country">Country</f:label>
			<f:input path="country" type="text" />
		</p>
		<p>
			<f:label path="city">City</f:label>
			<f:input path="city" type="text" />
		</p>
		<input type="submit" class="btn btn-primary" value="UPDATE" />
	</f:form>
	<br>
	<br>

	<form id="deleteForm">
	  <button onclick="sendDelete('/airport/delete', ${airportForm.id})">Delete</button>
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