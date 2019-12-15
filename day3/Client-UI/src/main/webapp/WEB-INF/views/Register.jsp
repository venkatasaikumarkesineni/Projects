<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.a {
	border: black solid 1px;
	border-style: double;
	padding: 10px;
	background-color: #C0C0C0;
}

.b {
	text-align: center;
}
</style>
</head>
<body>
	<center>
		<table class="a">
			<form:form action="save" modelAttribute="login" method="post">
				<tr>
					<td>Username:<form:input path="username" />
					</td>
				</tr>
				<tr>
					<td>Passworrd:<form:input path="password" />
					</td>
				</tr>
				<tr class="b">
					<td><input type="submit" value="Register"></td>
				</tr>
			</form:form>
		</table>
	</center>
</body>
</html>