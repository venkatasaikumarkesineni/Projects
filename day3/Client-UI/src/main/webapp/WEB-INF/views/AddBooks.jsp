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
table {
	border-collapse: collapse;
}

.a {
	text-align: center;
}
</style>
</head>
<body>
<a href="/home">Home Page</a>
	<center>
		<c:set var="check" value="${status}"></c:set>
		<c:if test="${check == 1 }">
			<p>Book Added Successfully</p>
		</c:if>
		<c:if test="${check == 0 }">
			<p>Adding book is failed Please Enter Proper Book Details</p>
		</c:if>
		<table border="3">
			<form:form method="post" action="InsertBooks" modelAttribute="books">
				<tr>
					<td>Book Id :<form:input path="bookid" />
					</td>
				</tr>
				<tr>
					<td>Book Name :<form:input path="bookname" />
					</td>
				</tr>
				<tr>
					<td>Author : <form:input path="author" />
					</td>
				</tr>
				<tr>
					<td>Availablebooks : <form:input path="availablebooks" />
				<tr>
					<td class="a"><input type="submit" value="Add Books" /></td>
				</tr>
			</form:form>
		</table>
	</center>
</body>
</html>