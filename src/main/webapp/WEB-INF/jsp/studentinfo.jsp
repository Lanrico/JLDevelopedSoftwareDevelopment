<%@ page language="java" pageEncoding="UTF-8"
import="com.example.demo.model.*"%>
<%@ page import="java.math.BigDecimal" %>
<!DOCTYPE html>
<head>
	<title>Student Information</title>
	<link href="https://cdn.staticfile.org/twitter-bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
	<link href="css/all.css" rel="stylesheet" type="text/css">
	<script src="https://cdn.staticfile.org/twitter-bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>

</head>
<%
	StudentEntity student = (StudentEntity) session.getAttribute("user");
	String ID = student.getId();
	String name = student.getName();
	String dept = student.getDepartment().getDeptName();
	BigDecimal tot_cred = student.getTotCred();
	String password = student.getPassword();
	String instructor = student.getInstructors().getName();

%>
<body>
<div class="mainContainer">
	<table class="table table-condensed">
		<tr>
			<td>Student Number：</td>
			<td><%=ID%></td>
		</tr>
		<tr>
			<td>Student Name：</td>
			<td><%=name%></td>
		</tr>
		<tr>
			<td>Department：</td>
			<td><%=dept%></td>
		</tr>
		<tr>
			<td>Total Credit：</td>
			<td><%=tot_cred%></td>
		</tr>
		<tr>
			<td>Instructor Name：</td>
			<td><%=instructor%></td>
		</tr>
		<tr>
			<td>Password：</td>
			<td><%=password%></td>
		</tr>
	</table>
	<form action="\validate" method="get">
		<input class="btn btn-outline-dark centerButton" type="submit" value="Back"/>
	</form>
</div>
</body>
</html>