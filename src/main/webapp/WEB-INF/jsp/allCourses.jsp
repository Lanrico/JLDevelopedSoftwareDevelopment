<%@ page language="java" pageEncoding="UTF-8"
import="java.util.*, com.example.demo.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%
	List<String> coursenamelist=(List<String>)session.getAttribute("coursenamelist");
%>
<head>
	<title>Course Information</title>
</head>
<body bgcolor="#D9DFAA">
	<table width="400" border="1">
		<caption>Course Information</caption>
		<tr>
			<th>Course Name</th><th>Operation</th>
		</tr>
		<c:forEach var="value" items="${coursenamelist}">  
		<tr>
			<td align="center">${value} </td>
			<td align="center">
				<a href="/courseSelection?coursename=${value}" 
					onClick="if(!confirm('Confirm Selection?'))
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
