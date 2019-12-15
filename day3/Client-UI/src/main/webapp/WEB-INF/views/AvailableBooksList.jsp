<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.a{
border: 3px;

}


</style>
</head>
<body>
<a href="/home">Home Page</a>
		<center>
		<form action="">
		<table border="3">		
				<tr>
					<th>No</th>
					<th>Book Id</th>
					<th>Author Name</th>
					<th>Book Name</th>
					<th>Available Books</th>
				</tr>
				<c:forEach var="list" items="${list}">
					<tr>
						<td>${list.no}</td>
						<td>${list.bookid}</td>
						<td>${list.author}</td>
						<td>${list.bookname}</td>
						<td>${list.availablebooks}</td>
						</tr>
				</c:forEach>
		</table>
		</form>
</center>
</body>
</html>