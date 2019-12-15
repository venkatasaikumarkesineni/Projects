<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="/home">Home Page</a>
	<c:set var="i" value="${a}"></c:set>
	<c:if test="${i == 404}">
		<center>
			<p>There are no Pending Books with this Student</p>
		</center>
	</c:if>
	<c:if test="${i == 500 }">
		<center>
			<p>Book Returned Sucessfully</p>
		</center>
	</c:if>
	<c:if test="${i == 501 }">
	<center>
	<p>Please select books to Return</p>
	</center>
	</c:if>
	<center>
		<form:form action="/return" method="post">
			<table border="3">
				<tr>
					<th>Student Id</th>
					<th>Book Id</th>
					<th>Book Name</th>
					<th>Author</th>
					<th>Book Distributed Date</th>
					<th>No Of Books</th>
					<th>Select</th>
				</tr>
				<c:forEach var="list" items="${list}">

					<tr>
						<td>${list.stdid}</td>
						<td>${list.bookid}</td>
						<td>${list.bookname}</td>
						<td>${list.author}</td>
						<td>${list.date}</td>
						<td>${list.noofbooks}</td>
						<td><input type="checkbox" name="books"
							value="${list.bookid}"></td>
					</tr>
				</c:forEach>
			</table>
			<br>
			<button>Return Books</button>
		</form:form>


	</center>
	<%
		Integer studentidd = (Integer) session.getAttribute("studentid");
	%>
	<a><%=studentidd%></a>

</body>
</html>



