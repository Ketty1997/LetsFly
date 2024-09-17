<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.letsfly.dto.*" %>
<%@page import="com.letsfly.form.*" %>
<!DOCTYPE html>
<html>
<head>
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
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/style.css">
<title>Ticket</title>
 </head>
<body >
<div id="navbar" class="sticky-top"></div>
<%FormTicketView ticketViewDto=(FormTicketView)request.getAttribute("ticketViewForm");%>
<div class="bodyTicket">
<div class="ticket">
	<div id="barBig">
		<!-- <img src="https://www.incimages.com/uploaded_files/image/1024x576/*Barcode_32896.jpg" alt="Bar Code"> -->
	</div>
	<div id="mainInfo">
		<div class="passenger-info-container">
			<div class="passenger-info">
				<span>Passenger Name</span>
				<br><br>
				<span class="details"><%out.println(ticketViewDto.getUserName());out.println(ticketViewDto.getUserSurname()); %></span>
			</div>
			<div class="passenger-info">
				<span>Departure Date</span>
				<br><br>
				<span class="details"> <%out.println(ticketViewDto.getDepartureDate().toLocalDate());%></span>
			</div>
			<div class="passenger-info">
				<span>Arrival Date</span>
				<br><br>
				<span class="details"> <%out.println(ticketViewDto.getArrivalDate().toLocalDate());%></span>
			</div>
		</div>
		<h1 class="destination">
			<%out.println(ticketViewDto.getAirportDeparture()); %>
			<img src="https://i.pinimg.com/originals/e9/0a/29/e90a299a041b7d37cdafc6eb2905e9d6.png" alt="Destination">
			<%out.println(ticketViewDto.getAirportArrival()); %>
		</h1>
		<div class="flight-info-container">
			<div class="flight-info">
				<span>Gate</span>
				<span>A 1</span>
			</div>
			<div class="flight-info">
				<span>Boarding Time</span>
				<span> <%out.println(ticketViewDto.getDepartureDate().toLocalTime().minusHours(1));%></span>
			</div>
			<div class="flight-info">
				<span>ETD</span>
				<span><%out.println(ticketViewDto.getDepartureDate().toLocalTime());%></span>
			</div>
			<div class="flight-info">
				<span>ETA</span>
				<span><%out.println(ticketViewDto.getArrivalDate().toLocalTime());%></span>
			</div>
		</div>
		<p class="note">Gate closes 20 minutes before departure</p>
	</div>
	<div id="circles">
		<div class="circle"></div>
		<div class="circle"></div>
		<div class="circle"></div>
		<div class="circle"></div>
		<div class="circle"></div>
		<div class="circle"></div>
		<div class="circle"></div>
		<div class="circle"></div>
		<div class="circle"></div>
		<div class="circle"></div>
		<div class="circle"></div>
		<div class="circle"></div>
		<div class="circle"></div>
		<div class="circle"></div>
		<div class="circle"></div>
		<div class="circle"></div>
		<div class="circle"></div>
		<div class="circle"></div>
		<div class="circle"></div>
		<div class="circle"></div>
		<div class="circle"></div>
		<div class="circle"></div>
		<div class="circle"></div>
		<div class="circle"></div>
		
	</div>
	<div id="sideInfo">
	<br>
		<img src="https://www.incimages.com/uploaded_files/image/1024x576/*Barcode_32896.jpg" alt="Small Bar" id="barSmall">
		<div class="details-container">
			<div class="flight-details">
				<div>
					<span>Name of Passenger</span>
					<span><%out.println(ticketViewDto.getUserName());out.println(ticketViewDto.getUserSurname()); %></span>
				</div>
				<div>
					<span>Departure Date</span>
					<span><%out.println(ticketViewDto.getDepartureDate().toLocalDate());%></span>
				</div>
				<div>
					<span>Arrival Date</span>
					<span><%out.println(ticketViewDto.getArrivalDate().toLocalDate());%></span>
				</div>
				<div>
					<span>Departure time</span>
					<span><%out.println(ticketViewDto.getDepartureDate().toLocalTime());%></span>
				</div>
					<div>
					<span>Arrival time</span>
					<span><%out.println(ticketViewDto.getArrivalDate().toLocalTime());%></span>
				</div>
			</div>
			<div class="destination-details">
				<%out.println(ticketViewDto.getAirportDeparture()); %>
				<img src="https://i.pinimg.com/originals/e9/0a/29/e90a299a041b7d37cdafc6eb2905e9d6.png" alt="Destination">
				<%out.println(ticketViewDto.getAirportArrival()); %>
			</div>
		</div>
	</div>
</div>
</div>
    <script>
    $('#navbar').load('/views/navbar.jsp');
</script>
</body>
</html>