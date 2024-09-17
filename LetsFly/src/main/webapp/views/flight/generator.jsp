<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.letsfly.utils.FlightGenerator"%>
<%@ page import="java.util.List"%>
<%@ page import="java.time.LocalDate"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Generate Flights</title>
</head>
<body>
<f:form modelAttribute="flightGenerator"  method="POST" action="/genFlight/inserimento" >
        <p>
            <f:label path="fromDate">From Date:</f:label>
            <f:input path="fromDate" type="date" />

       </p>
        <p>
            <f:label path="toDate">To Date:</f:label>
            <f:input path="toDate" type="date" />
        </p>
        <input type="submit"  class="btn btn-primary" value="Generate" />
    </f:form>
</body>
</html>