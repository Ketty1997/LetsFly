<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%> <%@ taglib uri="http://www.springframework.org/tags/form"
prefix="f"%> <%@ page import="com.letsfly.form.FormFlightSearch"%> <%@ page
import="com.letsfly.model.Airport"%>

<!DOCTYPE html>
<html lang="en" class="h-100">
  <head>
    <meta charset="UTF-8" />
    <title>Your flight</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
      crossorigin="anonymous"
    ></script>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
      crossorigin="anonymous"
    />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&family=Ubuntu:ital,wght@0,300;0,400;0,500;0,700;1,300;1,400;1,500;1,700&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css"  href="\css\common.css">
    <link rel="stylesheet" type="text/css"  href="\css\findFlight.css">
    <script src="\js\todayDate.js"></script>
  </head>
  <body class="h-100" onload="myFunction()">
  <div id="navbar" class="sticky-top"></div>
    <div class="container h-100">
      <div class="row h-100">
        <div class="col"></div>
        <div class="col d-flex align-items-center justify-content-center">
          <!-- Form start -->
          <f:form
            class="form-group border box rounded"
            modelAttribute="formFlightSearch"
            method="POST"
            action="/findFlight/flights">

            <!-- Departure -->
            <p>
              <f:label path="airportDeparture">Airport Departure:</f:label>
              <f:select
                path="airportDeparture"
                title="AirportDeparture"
                class="form-select custom-shadow"
              >
                <f:option
                  value="0"
                  label="Select the airport of departure"
                  selected="true"
                  disabled="true"
                />
    
                <c:forEach var="airport" items="${listAirport}">
                  <f:option value="${airport.id}" label="${airport.city}" />
                </c:forEach>
              </f:select>
            </p>

            <!-- Arrival -->
            <p>
              <f:label path="airportArrival">Airport Arrival:</f:label>
              <f:select
                path="airportArrival"
                title="AirportArrival"
                class="form-select custom-shadow"
              >
                <f:option value="0" label="Select the airport of departure" />
    
                <c:forEach var="airport" items="${listAirport}">
                  <f:option value="${airport.id}" label="${airport.city}" />
                </c:forEach>
              </f:select>
            </p>
    
            <!-- Date -->
            <p>
              <f:label path="dateDeparture">Date of Departure:</f:label>
              <f:input path="dateDeparture" type="date" class="form-control custom-shadow date"/>
            </p>
    
            <!-- Submit -->
            <div class="d-flex justify-content-end">
              <button type="submit" class="btn button rounded-pill">&#x2794;</button>
            </div>
          </f:form>
        </div>
        <div class="col"></div>
    </div>
    <script>
    $('#navbar').load('/views/navbar.jsp');
</script>
  </body>
</html>
