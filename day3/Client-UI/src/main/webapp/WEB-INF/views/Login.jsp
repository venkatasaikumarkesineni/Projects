<%@page import="org.bouncycastle.crypto.tls.AlertDescription"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function js() {
		if (document.getElementById("user").value == "") {
			alert("Please Enter Your UserName");
		} else if (document.getElementById("pwd").value == "") {
			alert("Please Enter Your Password");
		} else {
			document.getElementById("submitt").submit();
		}
	}
</script>
<style type="text/css">
.a {
	border: black solid 1px;
	border-style: double;
	padding: 10px;
	background-color: #C0C0C0;
}

.b {
	text-align: center;
	padding-left: 15px;
}
</style>
</head>
<body>
	<center>
		<c:set var="err" value="${error}"></c:set>
		<c:if test="${err == 500 }">
			<script type="text/javascript">
				alert("Please Enter Proper Credentials");
			</script>
		</c:if>
		<table class="a">
			<form:form id="submitt" action="authenticate" modelAttribute="login"
				method="post">
				<tr>
					<td>User name:<form:input path="username" id="user"
							placeholder="Enter your user name" />
					</td>
				</tr>
				<tr>
					<td>Password:<form:input path="password" type="password"
							id="pwd" placeholder="Enter your user Password" />
					</td>
				</tr>
				<tr class="b">
					<td><input type="button" value="Login" onclick="js()">
						<a href="/register"> New Register</a></td>
				</tr>
			</form:form>
		</table>
	</center>

</body>
</html>