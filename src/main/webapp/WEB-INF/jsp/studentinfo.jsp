<%@ page language="java" pageEncoding="UTF-8"
import="com.example.demo.model.*"%>
<%@ page import="java.math.BigDecimal" %>
<html>
<head>
	<title>Student Information</title>
</head>
<%
//	UserTable0 user=(UserTable0)session.getAttribute("user");
//	StudentTable0 stu=user.getStudent();
//	String studentname=stu.getStudentname();
//	String gender=stu.getGender();
//	String dateofbirth=stu.getDateofbirth();
//	Integer age=stu.getAge();
//	MajorTable0 major=stu.getMajor();
//	String majorname=major.getMajorname();
	StudentEntity student = (StudentEntity) session.getAttribute("user");
	String ID = student.getId();
	String name = student.getName();
	String dept = student.getDepartment().getDeptName();
	BigDecimal tot_cred = student.getTotCred();
	String password = student.getPassword();
	String instructor = student.getInstructors().getName();

%>
<body bgcolor="#D9DFAA">
	<table width="400">
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
		<input type="submit" value="Back"/>
	</form>
</body>
</html>