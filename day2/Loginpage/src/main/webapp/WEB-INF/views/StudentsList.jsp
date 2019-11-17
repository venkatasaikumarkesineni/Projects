<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.sai {
	border-collapse: collapse;
	padding: 2px;
}
</style>
</head>
<body>
	<center>

		<table border="2" class="sai">
			<tr>
				<th>Student Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Department</th>
				<th>Year</th>
				<th>Stay</th>
				<th>Delete</th>
			</tr>
			<form:forEach var="saii" items="${sai}">
				<tr>
					<td>${saii.stdid}</td>
					<td>${saii.firstname}</td>
					<td>${saii.lastname}</td>
					<td>${saii.dept}</td>
					<td>${saii.year}</td>
					<td>${saii.stay}</td>
					<td><a href="/delete/${saii.stdid}">Delete</a></td>
				</tr>
			</form:forEach>
		</table>
	</center>
	
	<form action="<form:url value="/search"/>">
	<input type="text" name="stdid" placeholder="Search By Student Id"/>
	<button>Find</button>
	</form>

</body>
</html>