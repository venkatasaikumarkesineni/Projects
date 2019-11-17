<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function login() {
		if (document.getElementById("user").value == "") {
			alert("Please enter your user name");
		} else if (document.getElementById("pwd").value == "") {
			alert("Please enter your password");
		} else {
			document.getElementById("submit").submit();
		}
	}
</script>
<style type="text/css">
.a {
	text-align: center;
	color: graytext;
}

table {
	border-collapse: collapse;
	padding: 5px;
}
.b{
color: red;
}
</style>
</head>
<body>
	<c:set var="login" value="${sai}" />
	<c:if test="${login == 404}">
		<center class="b">
			<p>Please Enter Correct Credentials</p>
		</center>
	</c:if>
	<center>
		<table border="3">
			<form:form action="authentication" id="submit" method="post"
				modelAttribute="login">
				<tr>
					<td>Username: <form:input path="username" id="user"></form:input>
					</td>
				</tr>
				<tr>
					<td>Password: <form:input path="password" id="pwd"></form:input>
					</td>
				</tr>
				<tr>
					<td class="a"><input type="button" value="login"
						onclick="login()"> <a href="/sairegister"> New
							Register</a></td>
				</tr>
			</form:form>
		</table>
	</center>

</body>
</html>