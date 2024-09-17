<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert routes</title>
</head>
<body>
	<p>
	<h1>SELECT THE ROUTE</h1>
	</p>
	<br>
	<br>

	<f:form modelAttribute="routeForm" method="POST" action="insert">
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
			<c:forEach var="day" items="${dayOfWeek}">
        		<div>
            	<input type="checkbox" name="availability" value="${day}"/>
            	<label>${day}</label>
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
		<input type="submit" class="btn btn-primary" value="Insert" />
	</f:form>


</body>
</html>