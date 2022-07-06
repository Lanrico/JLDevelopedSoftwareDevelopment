<%@ page language="java" pageEncoding="UTF-8"
import="java.util.*, com.example.demo.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%
	Set<SectionEntity> studentsectionlist=(Set<SectionEntity>)session.getAttribute("studentsectionlist");
%>
<head>
	<title>Course Management</title>
	<link href="https://cdn.staticfile.org/twitter-bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
	<link href="css/all.css" rel="stylesheet" type="text/css">
	<script src="https://cdn.staticfile.org/twitter-bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="mainContainer tableContainer">
	<table class="table table-striped">
	<caption>Your Course Information：</caption>
		<tr>
			<th>Course ID</th>
			<th>Course Name</th>
			<th>Credits</th>
			<th>Department</th>
			<th>Building</th>
			<th>Room Number</th>
			<th>Room Capacity</th>
			<th>Operation</th>
		</tr>
		<c:forEach var="value" items="${studentsectionlist}">
		<tr>
			<td align="center">${value.getCourse().getCourseId()}</td>
			<td align="center">${value.getCourse().getTitle()}</td>
			<td align="center">${value.getCourse().getCredits()}</td>
			<td align="center">${value.getCourse().getDepartment().getDeptName()}</td>
			<td align="center">${value.getClassroom().getBuilding()}</td>
			<td align="center">${value.getClassroom().getRoomNumber()}</td>
			<td align="center">${value.getClassroom().getCapacity()}</td>
			<td align="center">
				<a href="/deleteCourse?courseId=${value.getCourse().getCourseId()}"
				onClick="if(!confirm('Are you sure you want to drop this course？'))return false;else return true;">
				Drop</a>
			</td>
		</tr>
		</c:forEach> 
	</table>
	<form action="\validate" method="get">
		<input class="btn btn-outline-dark centerButton" type="submit" value="Back"/>
	</form>
	<br>
</div>
</body>
</html>