<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
<%@page import="com.letsfly.dto.*"%>
<%@page import="com.letsfly.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Flight</title>
</head>
<body>
<form action="" method="get">
		<select name="select" onchange="location = this.value;">
			<option value="">Select Flight</option>
			<%
			List<FlightDto> flightList = (List<FlightDto>) request.getAttribute("flightListForm");
			for (FlightDto flightDto : flightList) {
				String url = "/flight/preUpdate/" + flightDto.getId();
			%>
			<option value="<%=url%>"><%=flightDto.getId()%></option>
			<%
			}
			%>
		</select>
	</form>
</body>
</html>