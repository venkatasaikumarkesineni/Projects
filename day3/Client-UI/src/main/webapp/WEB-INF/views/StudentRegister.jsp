<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="Student-Register" method="post" modelAttribute="students">
Stdid:<form:input path="stdid"/>
Name:<form:input path="name"/>
Dept:<form:input path="dept"/>
Batch:<form:input path="batch"/>
<input type="submit" value="Register">
</form:form>
</body>
</html>