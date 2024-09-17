<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.letsfly.utils.FlightGenerator"%>
<%@page import="com.letsfly.dto.FlightDto"%>
<%@ page import="java.util.List"%>
<%@ page import="java.time.LocalDate"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
FlightGenerator fG = (FlightGenerator) request.getAttribute("flightGenerator");
List<FlightDto> lF = fG.getGenerated();
request.setAttribute("flightGenerator",fG);
%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Generate Flights</title>
</head>
<body>
<table class="table">
		<tr>
			<th>Route</th>
			<th>Departure Date</th>
			<th>Arrival Date</th>
		</tr>
		<%
		for (FlightDto s : lF) {
		%>
		<tr>
			<td>
				<%
				out.println(s.getRoute());
				%>
			</td>
			<td>
				<%
				out.println(s.getDateDeparture());
				%>
			</td>
			<td>
				<%
				out.println(s.getDateArrival());
				%>
			</td>
		<tr>

			<%
			}
			%>
		
		<tr>
			<td><a class="btn btn-primary" href="/genFlight/inserisci" role="button">Insert!</a>
			</td>
		</tr>
</table>
</body>
</html>