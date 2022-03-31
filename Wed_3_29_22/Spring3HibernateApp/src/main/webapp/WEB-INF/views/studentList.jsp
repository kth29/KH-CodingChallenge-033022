<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Students</title>
</head>
<body>
<h1>List Students</h1>
<h3><a href="addStudent.html">Add New Student</a></h3>

<c:if test="${!empty students}">
	<table align="left" border="1">
		<tr>
			<th>Student ID</th>
			<th>Student Name</th>
			<th>Student Email</th>
		</tr>

		<c:forEach items="${students}" var="student">
			<tr>
				<td><c:out value="${student.id}"/></td>
				<td><c:out value="${student.name}"/></td>
				<td><c:out value="${student.email}"/></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>