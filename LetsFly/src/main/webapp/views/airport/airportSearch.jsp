<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@page import="java.util.List"%>
<%@page import="com.letsfly.form.*"%>
<%@page import="com.letsfly.model.*"%>

<!DOCTYPE html>
<html>
	<head>
		<c:set var="counter" value="0" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&family=Ubuntu:ital,wght@0,300;0,400;0,500;0,700;1,300;1,400;1,500;1,700&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css"  href="\css\common.css">
	<link rel="stylesheet" type="text/css"  href="\css\departureArrivalTable.css">
		<link
			href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
			rel="stylesheet"
			integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
			crossorigin="anonymous" />
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
		<meta charset="ISO-8859-1">
		<title>Airport Search</title>
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	</head>
	<body class="d-flex flex-column align-items-center">
		<div id="navbar" class="w-100"></div>

		<!-- ricerca voli per aereoporto -->
		<div class="container h-100 m-2">
			<div id="carousel" class="carousel slide h-100">

				<div class="carousel-inner h-100">
					
					<!-- barra bottoni per cambiare citta' -->
					<div class="container row">
						<div class="d-flex flex-row m-1 justify-content-center">
							<button class="arrow m-1 carousel-control-prev;overflow: hidden" type="button"
								data-bs-target="#carousel"
								data-bs-slide="prev">
								<span class="carousel-control-prev-icon h-100" aria-hidden="true"></span>
								<span class="visually-hidden">Previous</span>
							</button>
	
							<h1 id="headerTitle">${FormAirportViewL.get(0).getCountry()}, ${FormAirportViewL.get(0).getCity()}</h1>
							<button class="arrow m-1 carousel-control-next;overflow: hidden" type="button"
								data-bs-target="#carousel"
								data-bs-slide="next">
								<span class="carousel-control-next-icon h-100" aria-hidden="true"></span>
								<span class="visually-hidden">Next</span>
							</button>
						</div>
					</div>

					<!-- bottoni mostra andata o ritorno dalla citta' -->
					<div class="m-1 d-flex flex-row justify-content-center d-inline">
						<div class="container m-0 d-flex justify-content-lg-end">
							<button id="departureButton" type="button" class="col-6 btn button-30 disabled" onclick="showDeparture();">
								Departures</button>
						</div>
						<div class="container m-0">
							<button id="arrivalButton" type="button" class="col-6 button-30" onclick="showArrival();">Arrivals</button>
						</div>
					</div>
					
					<!-- contenuti con voli-->
					<c:forEach var="formAirport" items="${FormAirportViewL}">
						<c:choose>
							<c:when test="${counter==0}">
								<div class="carousel-item active">
							</c:when>
							<c:otherwise>
								<div class="carousel-item">
							</c:otherwise>
						</c:choose>

						<div id="title" style="display: none">${formAirport.getCountry()}, ${formAirport.getCity()}</div>
						<div class="departure" style="display: block">
							<table class="table table-hover">
								<th class="col-3">Towards</th>
								<th class="col-3">Departure</th>
								<th class="col-3">Arrival</th>
								<th class="col-3">Availability</th>
								<c:forEach var="routeDeparture"
									items="${formAirport.getListRouteDeparture()}">
									<tr>
										<td>${routeDeparture.getAirportArrival()}</td>
										<td>${routeDeparture.getDepartureTime()}</td>
										<td>${routeDeparture.getArrivalTime()}</td>
										<td><c:forEach var="day"
												items="${formAirport.getWeekDays()}">
												<c:choose>
													<c:when
														test="${routeDeparture.getAvailability().contains(day)}">
														<p class="present d-inline">${day.charAt(0)}</p>
													</c:when>
													<c:otherwise>
														<p class="missing d-inline">${day.charAt(0)}</p>
													</c:otherwise>
												</c:choose>
											</c:forEach></td>
									</tr>
								</c:forEach>
							</table>
						</div>
						<div class="arrival" style="display: none">
							<table class="table table-hover">
								<th class="col-3">From</th>
								<th class="col-3">Departure</th>
								<th class="col-3">Arrival</th>
								<th class="col-3">Availability</th>
								<c:forEach var="routeArrival"
									items="${formAirport.getListRouteArrival()}">
									<tr>
										<td>${routeArrival.getAirportDeparture()}</td>
										<td>${routeArrival.getDepartureTime()}</td>
										<td>${routeArrival.getArrivalTime()}</td>
										<td><c:forEach var="day"
												items="${formAirport.getWeekDays()}">
												<c:choose>
													<c:when
														test="${routeArrival.getAvailability().contains(day)}">
														<p class="present d-inline">${day.charAt(0)}</p>
													</c:when>
													<c:otherwise>
														<p class="missing d-inline">${day.charAt(0)}</p>
													</c:otherwise>
												</c:choose>
											</c:forEach></td>
									</tr>
								</c:forEach>
							</table>
						</div>
				</div>
				<c:set var="counter" value="1" />
				</c:forEach>
			</div>
		</div>

		<script>
			var departureElement = document.getElementsByClassName("departure");
			var departureButton = document.getElementById('departureButton');
			var arrivalElement = document.getElementsByClassName("arrival");
			var arrivalButton = document.getElementById('arrivalButton');
			var myTitle = document.getElementById('headerTitle');
			var myCarousel = document.getElementById('carousel');

			myCarousel.addEventListener('slide.bs.carousel', function (event) {
				var activeElement = event.relatedTarget.querySelector("div").innerText;
				headerTitle.innerText=activeElement;
				//showDeparture(); // se vogliamo reimpostare la tabella quando cambiamo slide
				});

			function showArrival() {
				if (departureElement) {
					Array.from(departureElement).forEach(element=>{
					element.style.display = "none";});
				}
				if(arrivalElement){
					Array.from(arrivalElement).forEach(element=>{
						element.style.display ="block";});
				}
				departureButton.setAttribute("class","col-6 button-30");
				arrivalButton.setAttribute("class","col-6 btn button-30 disabled");
			}
			function showDeparture() {
				if (departureElement) {
					Array.from(departureElement).forEach(element=>{
					element.style.display = "block";});
				}
				if(arrivalElement){
					Array.from(arrivalElement).forEach(element=>{
						element.style.display ="none";});
				}
				departureButton.setAttribute("class","col-6 btn button-30 disabled");
				arrivalButton.setAttribute("class","col-6 button-30");
			}
			$('#navbar').load('/views/navbar.jsp');
		</script>
	</body>
</html>