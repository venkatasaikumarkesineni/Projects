<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.a{

border-collapse: collapse;
}

</style>
</head>
<body>
<a href="/home">Home Page</a>
	<center>
	<table border="3" class="a">
		<tr>
			<th>StudentId</th>
			<th>Book Name</th>
			<th>Book Id</th>
			<th>Author</th>
			<th>Book Distributed Date</th>
			<th>No Of Books</th>
		</tr>

		<c:forEach var="list" items="${lst}">
			<tr>
				<td>${list.stdid}</td>
				<td>${list.bookname}</td>
				<td>${list.bookid}</td>
				<td>${list.author}</td>
				<td>${list.date}</td>
				<td>${list.noofbooks}</td>
			</tr>

		</c:forEach>
	</table>
	</center>
</body>
</html>