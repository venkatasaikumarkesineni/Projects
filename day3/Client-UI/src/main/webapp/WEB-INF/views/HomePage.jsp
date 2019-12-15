<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table{
border-collapse: collapse;
}

</style>
</head>
<body>
	<c:set var="time" value="${siri}" ></c:set>
	<c:if
		test="${(time >= 00 && time < 12)}">
		<center>
			<h1>Good Morning ${sai}, Hope You Are Doing Well !</h1>
		</center>
	</c:if>
	<c:if test="${(time >=12 && time <17)}">
		<center>
			<h1>Good AfterNoon ${sai}, Hope You Are Doing Well !</h1>
		</center>
	</c:if>
	<c:if test="${(time >= 17 && time <= 24)}">
		<center>
			<h1>Good Evening ${sai}, Hope You Are Doing Well !</h1>
		</center>
	</c:if>
	<c:if test="${time == 404 }">
	<center>
	<h2>Stdid Not Found, Please Register With DataBasee
	<a href="/StudentRegister">Student Register</a>
	</h2>
	</center>
	</c:if>
	<center>
	<a href="/AvailableBooks">Available Books</a>&nbsp&nbsp&nbsp&nbsp
	<a href="/AddBooks">Add Books</a>&nbsp&nbsp&nbsp&nbsp
	<a href="/DistributeBooks"> Distribute Books</a>&nbsp&nbsp&nbsp&nbsp
	<a href="/ReturnBooks">Return Books</a>
</center>
</body>
</html>