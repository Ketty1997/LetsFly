<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List"%>
<%@ page import="com.letsfly.dto.*"%>
<%@ page import="com.letsfly.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Search</title>
</head>
<body>
<form action="" method="get">
		<select name="select" onchange="location = this.value;">
			<option disabled selected>select User</option>

			<c:forEach var="item" items="${userListForm}">
			  <option value="/user/preUpdate/${item.getId()}">  <c:out value = "${item.id}">Error</c:out> </option>
      </c:forEach>

		</select>
	</form>

</body>
</html>