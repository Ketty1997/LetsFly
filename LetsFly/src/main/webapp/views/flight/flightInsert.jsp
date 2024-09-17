<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Flight</title>
<meta charset="UTF-8">
</head>
<body>
<p>
	<h1>INSERT FLIGHT</h1>
	</p>
	<br>
	<br>
	<f:form modelAttribute="flightForm" method="POST"
		action="/flight/insert">
		<p>
			<f:label path="route">Route:</f:label>
			<f:input path="route" type="number"/>
		</p>
		<p>
			<f:label path="dateDeparture">Date of Departure:</f:label>
			<f:input path="dateDeparture" type="date" />
		</p>
		<p>
			<f:label path="timeDeparture">Time of Departure:</f:label>
			<f:input path="timeDeparture" type="time" />
		</p>
		<p>
			<f:label path="dateArrival">Date of Arrival:</f:label>
			<f:input path="dateArrival" type="date"/>
		</p>
		<p>
			<f:label path="timeArrival">Time of Arrival:</f:label>
			<f:input path="timeArrival" type="time" />
		</p>
		<input type="submit" class="btn btn-primary" value="Insert" />
	</f:form>
</body>
</html>