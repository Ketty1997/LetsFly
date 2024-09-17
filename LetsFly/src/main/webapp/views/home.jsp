<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>

	<h1>Home Page</h1>

	<form id="form">
		<button type="button" onclick="send('/airplane/', 'preInsert', 'get')">Insert
			Airplane</button>
		<button type="button" onclick="send('/airplane/', 'findAll', 'get')">Search
			Airplane</button>
	</form>
	<br>
	<form id="form">
		<button type="button" onclick="send('/airport/', 'preInsert', 'get')">Insert
			Airport</button>
		<button type="button" onclick="send('/airport/', 'findAll', 'get')">Search
			Airport</button>
	</form>
	<br>
	<form id="form">
		<button type="button" onclick="send('/flight/', 'preInsert', 'get')">Insert
			Flight</button>
		<button type="button" onclick="send('/flight/', 'findAll', 'get')">Search
			Flight</button>
		<button type="button" onclick="send('/genFlight', '', 'get')">Generate
			Flights</button>
	</form>
	<br>
	<form id="form">
		<button type="button" onclick="send('/route/', 'preInsert', 'get')">Insert
			Route</button>
		<button type="button" onclick="send('/route/', 'findAll', 'get')">Search
			Route</button>
	</form>
	<br>
	<form id="form">
		<button type="button" onclick="send('/ticket/', 'preInsert', 'get')">Insert
			Ticket</button>
		<button type="button" onclick="send('/ticket/', 'findAll', 'get')">Search
			Ticket</button>
		<button type="button" onclick="send('/findFlight', '', 'get')">Book
			Ticket</button>
	</form>
	<br>
	<form id="form">
		<button type="button" onclick="send('/user/', 'preInsert', 'get')">Insert
			user</button>
		<button type="button" onclick="send('/user/', 'findAll', 'get')">Search
			user</button>
	</form>

</body>

<script>
	function send(section, action, method) {
		var form = document.getElementById("form");
		form.action = section + action;
		form.method = method;

		form.submit();
	}
</script>
</html>