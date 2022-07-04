<%@ page language="java" pageEncoding="UTF-8"
import="java.util.*, com.example.demo.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%
//	List<String> coursenamelist=(List<String>)session.getAttribute("coursenamelist");
	List<SectionEntity> allcourselist=(List<SectionEntity>)session.getAttribute("allcourselist");
%>
<head>
	<title>Course Information</title>
</head>
<body bgcolor="#D9DFAA">
	<table width="400" border="1">
		<caption>Course Information</caption>
		<tr>
			<th>Course ID</th>
			<th>Course Name</th>
			<th>Credits</th>
			<th>Department</th>
			<th>Building</th>
			<th>Operation</th>
		</tr>
		<c:forEach var="value" items="${allcourselist}">
		<tr>
			<td align="center">${value.getCourseId()}</td>
			<td align="center">${value.getTitle()}</td>
			<td align="center">${value.getCredits()}</td>
			<td align="center">${value.getDepartment().getDeptName()}</td>
			<td align="center">${value.getDepartment().getBuilding()}</td>
			<td align="center">
				<a href="/courseSelection?courseId=${value.getCourseId()}"
					onClick="if(!confirm('Are you sure to select this course?'))
					return false;else return true;">Select</a>
			</td>
		</tr>
		</c:forEach> 
	</table>
	<form action="\validate" method="get">
		<input type="submit" value="Back"/>
	</form>
</body>
</html>
