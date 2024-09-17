<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="com.letsfly.dto.*"%>
<%@page import="com.letsfly.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Ticket</title>
</head>
<body>
	<form action="" method="get">
		<select name="select" onchange="location = this.value;">
			<option value="">Select a ticket</option>
			<%
			List<TicketDto> ticketList = (List<TicketDto>) request.getAttribute("ticketListForm");
			for (TicketDto ticketDto : ticketList) {
				String url = "/ticket/preUpdate/" + ticketDto.getId();
			%>
			<option value="<%=url%>"><%=ticketDto.getId()%></option>
			<%
			}
			%>
		</select>
	</form>
</body>
</html>