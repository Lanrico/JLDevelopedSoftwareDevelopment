<%@ page language="java" pageEncoding="UTF-8"
import="java.util.*, com.example.demo.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%
	List<String> studentcoursenamelist=(List<String>)session.getAttribute("studentcoursenamelist");
%>
<head>
	<title>Course Management</title>
</head>
<body bgcolor="#D9DFAA">
	<table width="400" border=1>
	<caption>Your Course Information：</caption>
		<tr>
			<th>Course Name</th><th>Operation</th>
		</tr>
		<c:forEach var="value" items="${studentcoursenamelist}">
		<tr>
			<td align="center">${value}</td>
			<td align="center">
				<a href="/deleteCourse?coursename=${value}"
				onClick="if(!confirm('Confirm deletion？'))return false;else return true;">
				Drop</a>
			</td>
		</tr>
		</c:forEach> 
	</table>
	<form action="\validate" method="get">
		<input type="submit" value="Back"/>
	</form>
</body>
</html>