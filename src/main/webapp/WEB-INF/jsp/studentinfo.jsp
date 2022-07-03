<%@ page language="java" pageEncoding="UTF-8"
import="com.example.demo.model.*"%>
<html>
<head>
	<title>Student Information</title>
</head>
<%
	UserTable0 user=(UserTable0)session.getAttribute("user");
	StudentTable0 stu=user.getStudent();
	String studentname=stu.getStudentname();
	String gender=stu.getGender();
	String dateofbirth=stu.getDateofbirth();
	Integer age=stu.getAge();
	MajorTable0 major=stu.getMajor();
	String majorname=major.getMajorname();
%>
<body bgcolor="#D9DFAA">
	<table width="400">
		<tr>
			<td>Name：</td>
			<td><%=studentname%></td>
		</tr>
		<tr>
			<td>Gender：</td>
			<td><%=gender%></td>
		</tr>
		<tr>
			<td>Date of Birth：</td>
			<td><%=dateofbirth%></td>
		</tr>
		<tr>
			<td>Age：</td>
			<td><%=age%></td>
		</tr>
		<tr>
			<td>Major：</td>
			<td><%=majorname%></td>
		</tr>
	</table>
	<form action="\validate" method="get">
		<input type="submit" value="Back"/>
	</form>
</body>
</html>