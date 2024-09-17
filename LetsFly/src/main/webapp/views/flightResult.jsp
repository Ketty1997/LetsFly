<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Flight Result</title>
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
	crossorigin="anonymous" />
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&family=Ubuntu:ital,wght@0,300;0,400;0,500;0,700;1,300;1,400;1,500;1,700&display=swap"
	rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="\css\common.css">
<link rel="stylesheet" type="text/css" href="\css\flightResults.css" />
</head>
<body class="h-100">
<div id="navbar" class="sticky-top"></div>
	<div class="container h-100">
		<div class="row h-100">
			<div class="col"></div>
			<div class="d-flex justify-content-center align-items-center col-8">
				<table class="box">
					<thead>
						<tr>
							<th>Departure</th>
							<th></th>
							<th>Arrival</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach var="listsubflight" items="${listListFlight}">
							<f:form modelAttribute="choosenFlights" method="POST"
								action="/findFlight/tickets">
								<c:forEach var="flight" items="${listsubflight}">
									<f:hidden value="${flight.id}" path="list" />
									<tr>
										<td>${flight.getAirportDeparture()}<br>${flight.getTimeDeparture().toLocalDate()}<br>${flight.getTimeDeparture().toLocalTime()}</td>
										<td><img
											style="transform: rotate(45deg); max-height: 10vh"
											src="https://i.pinimg.com/originals/e9/0a/29/e90a299a041b7d37cdafc6eb2905e9d6.png"
											alt="Destination"></td>
										<td>${flight.getAirportArrival()}<br>${flight.getTimeArrival().toLocalDate()}<br>${flight.getTimeArrival().toLocalTime()}</td>
									</tr>
								</c:forEach>
								<tr style="border-bottom: 1px solid black;">
									<td colspan="2">Travel Time :
										${listsubflight.get(0).getTimeDeparture().until(listsubflight.get(listsubflight.size()-1).getTimeArrival(),chronoH)}:${listsubflight.get(0).getTimeDeparture().until(listsubflight.get(listsubflight.size()-1).getTimeArrival().minusHours(listsubflight.get(0).getTimeDeparture().until(listsubflight.get(listsubflight.size()-1).getTimeArrival(),chronoH)),chronoM)}<br>
										Stopovers : ${listsubflight.size()}
									</td>
									<td style="text-align: center;"><input type="submit"
										value="Book"></td>
								</tr>
							</f:form>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col"></div>
		</div>
	</div>
	<script>
    $('#navbar').load('/views/navbar.jsp');
</script>
</body>
</html>
