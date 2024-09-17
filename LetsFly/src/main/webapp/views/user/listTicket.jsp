<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%> <%@ taglib uri="http://www.springframework.org/tags/form"
prefix="f"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="\css\common.css"/>
    <link rel="stylesheet" href="/styleFormUser.css" />
    <title>User Tickets</title>
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
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Bitter:ital,wght@0,100..900;1,100..900&family=Playfair+Display&family=Ubuntu:ital,wght@0,300;0,400;0,500;0,700;1,300;1,400;1,500;1,700&display=swap"
      rel="stylesheet"
    />
  </head>
  <body>
    <div id="navbar" class="sticky-top"></div>
    <div class="m-4 p-4 align-items-center">
      <table class="table table-striped">
        <thead>
          <tr>
            <td><strong>Departure</strong></td>
            <td><strong>Arrival</strong></td>
            <td></td>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="ticket" items="${userTickets}">
            <tr class="border-bottom-0">
              <td>${ticket.getAirportDeparture()}<br>${ticket.getDepartureDate().toLocalDate()} ${ticket.getDepartureDate().toLocalTime()}</td>
              <td>${ticket.getAirportArrival()}<br>${ticket.getArrivalDate().toLocalDate()} ${ticket.getArrivalDate().toLocalTime()}</td>
              <td>
                <f:form
                  modelAttribute="choosenTicket"
                  method="POST"
                  action="/ticket/ticketView"
                >
                  <f:hidden value="${ticket.getId()}" path="id" />
                  <input
                    type="submit"
                    value="Check Ticket"
                    class="gotoTicket"
                  />
                </f:form>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
    <script>
    $('#navbar').load('/views/navbar.jsp');
</script>
  </body>
</html>
