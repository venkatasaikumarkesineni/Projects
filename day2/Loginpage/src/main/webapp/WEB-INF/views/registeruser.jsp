<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	padding: 5px;
}
</style>
<script type="text/javascript">
	function register() {
		if (document.getElementById("pwd").value.length < 6
				|| document.getElementById("pwd").value.length > 9) {
			alert("Password should be in between 6 to 9 charecters");
		} else {

			document.getElementById("submit").submit();
		}
	}
</script>
</head>
<body>
	<center>
		<table border="3">
			<form:form action="registerCredentials" modelAttribute="login"
				method="post" id="submit">
				<tr>
					<td>Create UserName: <form:input path="username" id="user" /></td>
				</tr>
				<tr>
					<td>Create Password :<form:input path="password" id="pwd" /></td>
				</tr>

				<tr>
					<td class="a"><input type="button" value="Register"
						onclick="register()"></td>
				</tr>
			</form:form>
		</table>
	</center>
</body>
</html>