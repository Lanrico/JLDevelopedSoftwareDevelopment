<%@ page language="java" pageEncoding="UTF-8"
import="java.util.*, com.example.demo.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%
	Set<SectionEntity> studentsectionlist=(Set<SectionEntity>)session.getAttribute("studentsectionlist");
%>
<head>
	<title>Course Management</title>
</head>
<body bgcolor="#D9DFAA">
	<table width="400" border=1>
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
		<input type="submit" value="Back"/>
	</form>
	<br>
	<form action="\courseInfo" method="get">
		<input type="submit" value="Select Other Courses "/>
	</form>
</body>
</html>