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
<title>View Route</title>
</head>
<body>
<p>
	<h1>UPDATE OR DELETE THE ROUTE</h1>
	</p>
	<br>
	<br>
	<f:form modelAttribute="routeForm" method="POST" action="/route/update">
	<f:input path="id" type="hidden" />
		<p>
			<f:label path="airportArrival">Airport Departure:</f:label><br>
			<f:select path="airportDeparture" title="AirportDeparture" >
      			<f:option value="0" label="Select the airport of departure" selected="true" disabled="true"/>
      			<c:forEach var="airport" items="${listAirport}">
        			<f:option value="${airport.id}" label="${airport.city}"/>
      			</c:forEach>
			</f:select>
		</p>
		<p>
			<f:label path="airportArrival">Airport Arrival:</f:label><br>
    		<f:select path="airportArrival" title="AirportArrival" >
      			<f:option value="0" label="Select the airport of arrival"/>
      			<c:forEach var="airport" items="${listAirport}">
         			<f:option value="${airport.id}" label="${airport.city}"/>
      			</c:forEach>
    		</f:select>
		</p>
		<p>
			<f:label path="airportArrival">Availability:</f:label>
			<c:forEach var="day" items="${routeForm.availability}">
        		<div>
            	<input type="checkbox" name="availability" value="${day}" checked="true"/>
            	<label>${day}</label>
        		</div>
    		</c:forEach>
			<c:forEach var="daym" items="${listAvailabilty}">
        		<div>
            	<input type="checkbox" name="availability" value="${daym}"/>
            	<label>${daym}</label>
        		</div>
    		</c:forEach>
		</p>
		<p>
			<f:label path="departureTime">Departure's time:</f:label><br>
			<f:input path="departureTime" type="time" />
		</p>
		<p>
			<f:label path="duration">Duration:</f:label><br>
			<f:input path="duration" type="time" />
		</p>
		<p>
			<f:label path="airportArrival">Airplane:</f:label><br>
			<f:select path="airplane" title="Airplane" >
      			<f:option value="0" label="Select the airplane for the route" selected="true" disabled="true"/>
      			<c:forEach var="airplane" items="${listAirplane}">
        			<f:option value="${airplane.id}" label="${airplane.id}"/>
      			</c:forEach>
			</f:select>
		</p>
		<input type="submit" class="btn btn-primary" value="Update" />
	</f:form>
	<br>
	<br>

  <form id="deleteForm">
	  <button onclick="sendDelete('', ${routeForm.id})">Delete</button>
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