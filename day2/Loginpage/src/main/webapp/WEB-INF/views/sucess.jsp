<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.sai {
	padding: 3px;
}
</style>
<script type="text/javascript">
	function js() {
		if (document.getElementById("fn").value == "" || document.getElementById("ln").value == "" ||
				document.getElementById("dept").value == "SELECT" || document.getElementById("year").value == "0"
				|| document.getElementById("stay").value == "SELECT") {
			alert("Please provide the required fields");
		} else {
			document.getElementById("form").submit();
		}

	}
</script>
</head>
<body>
	<center>
		<h1>Welcome ${username}</h1>
		<table border="3" class="sai">
			<form:form action="studentdetails" modelAttribute="student"
				method="POST" id="form">
				<tr>
					<td>First Name: <form:input path="firstname" id="fn" />
					</td>
				</tr>
				<tr>
					<td>Last Name: <form:input path="lastname" id="ln" /></td>
				</tr>
				<tr>
					<td>Department : <form:select path="dept" id="dept">
							<form:option value="SELECT"></form:option>
							<form:option value="ECE"></form:option>
							<form:option value="CSE"></form:option>
							<form:option value="MECH"></form:option>
							<form:option value="BIO"></form:option>
							<form:option value="EEE"></form:option>
						</form:select></td>
				</tr>
				<tr>
					<td>Year : <form:input path="year" id="year" /></td>
				</tr>
				<tr>
					<td>Stay: <form:select path="stay" id="stay">
							<form:option value="SELECT"></form:option>
							<form:option value="Hostler"></form:option>
							<form:option value="DayScholar"></form:option>
						</form:select></td>
				</tr>
				<tr>
					<td><input type="button" value="save details" onclick="js()" /></td>
				</tr>
			</form:form>
		</table>

	</center>
	<a href="/ShowAllStudents"> Students List</a>

</body>
</html>