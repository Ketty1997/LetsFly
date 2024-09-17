<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Airplanes</title>
</head>

<body>
	<p>
	<h1>INSERT AIRPLANE</h1>
	</p>
	<br>
	<br>

	<f:form modelAttribute="airplaneForm" method="POST" action="/airplane/insert">
		<p>
			<f:label path="seatRow">Seat Rows:</f:label>
			<f:input path="seatRow" type="number" />
		</p>
		<p>
			<f:label path="seatColumn">Seat Columns:</f:label>
			<f:input path="seatColumn" type="number" />
		</p>
		<input type="submit" class="btn btn-primary" value="Insert" />
	</f:form>

</body>

</html>