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
.a {
	text-align: center;
}

table {
	border-collapse: collapse;
}
</style>
<script type="text/javascript">
	
</script>
</head>
<body>
	<center>
		<c:set var="failure" value="${failure}"></c:set>
		<c:if test="${failure == 1 }">
			<canter>
			<p>Please enter proper values</p>
			</canter>
		</c:if>
		<c:set var="check" value="${Historycheck}"></c:set>
		<c:if test="${check == 1}">
		<center>
		<p>Already you have taken book</p>
		</center>
		</c:if>
		
		<table border="3">
			<form:form action="distributeBooks" method="post"
				modelAttribute="books">
				<tr>
					<th>No</th>
					<th>Book Id</th>
					<th>Author Name</th>
					<th>Book Name</th>
					<th>Available Books</th>
					<th>Select</th>
				</tr>
				<c:forEach var="list" items="${list}">
					<tr>
						<td>${list.no}</td>
						<td>${list.bookid}</td>
						<td>${list.author}</td>
						<td>${list.bookname}</td>
						<td>${list.availablebooks}</td>
						<td><input type="radio" name="no" value="${list.no}" /></td>
				</c:forEach>
				</tr>
				<input type="submit" value="submit" />
			</form:form>
			<%
				Integer id = (Integer) session.getAttribute("stdid");
			%>
			Student id is :
			<a><%=id%></a>
		</table>
	</center>

</body>
</html>