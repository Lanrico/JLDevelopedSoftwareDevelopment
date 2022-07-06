<%@ page language="java" pageEncoding="UTF-8"
import="java.util.*, com.example.demo.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%
	List<SectionEntity> allcourselist=(List<SectionEntity>)session.getAttribute("allcourselist");
%>
<head>
	<title>Course Information</title>
	<link href="https://cdn.staticfile.org/twitter-bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
	<link href="css/all.css" rel="stylesheet" type="text/css">
	<script src="https://cdn.staticfile.org/twitter-bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="mainContainer tableContainer">
	<table class="table table-striped">
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
		<input class="btn btn-outline-dark centerButton" type="submit" value="Back"/>
	</form>
</div>
</body>
</html>
