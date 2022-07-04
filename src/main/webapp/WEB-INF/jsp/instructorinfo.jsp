<%@ page language="java" pageEncoding="UTF-8"
         import="com.example.demo.model.*"%>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Instructor Information</title>
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
    InstructorEntity instructor = (InstructorEntity) session.getAttribute("user");
    String ID = instructor.getId();
    String name = instructor.getName();
    String dept = instructor.getDepartment().getDeptName();
    String password = instructor.getPassword();
%>
<body bgcolor="#D9DFAA">
<table width="400" border=1>
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
        <td>Password：</td>
        <td><%=password%></td>
    </tr>
</table>
<form action="\validate" method="get">
    <input type="submit" value="Back"/>
</form>
</body>
</html>