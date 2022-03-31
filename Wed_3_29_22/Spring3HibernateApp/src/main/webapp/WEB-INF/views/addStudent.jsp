<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Spring MVC Form Handling</title>
	</head>
	<body>
		<h2>Add Student Data</h2>
		<form:form method="POST" action="saveStudent.html">
	   		<table>
			    <tr>
			        <td><form:label path="id">Student ID:</form:label></td>
			        <td><form:input path="id" value="${student.id}" readonly="true"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="name">Student Name:</form:label></td>
			        <td><form:input path="name" value="${student.name}"/></td>
			    </tr>
			    <tr>
			    	<td><form:label path="email">Student Email:</form:label></td>
			    	<td><form:input path="email" value="${student.email}" /></td>
			    
			    </tr>
			    <tr>
			      <td colspan="2"><input type="submit" value="Submit"/></td>
		      </tr>
			</table> 
		</form:form>
		
  <c:if test="${!empty students}">
		<h2>List Students</h2>
	<table align="left" border="1">
		<tr>
			<th>Student ID</th>
			<th>Student Name</th>
			<th>Student Email</th>
			<th>Actions on Row</th>
		</tr>

		<c:forEach items="${students}" var="student">
			<tr>
				<td><c:out value="${student.id}"/></td>
				<td><c:out value="${student.name}"/></td>
				<td><c:out value="${student.email}"/></td>
				<td align="center"><a href="editStudent.html?id=${student.id}">Edit</a> | <a href="deleteStudent.html?id=${student.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
	</body>
</html>