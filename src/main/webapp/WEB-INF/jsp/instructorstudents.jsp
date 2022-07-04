<%@ page language="java" pageEncoding="UTF-8"
         import="java.util.*, com.example.demo.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%
    List<StudentEntity> instructorstudentlist=(List<StudentEntity>)session.getAttribute("instructorstudentlist");
%>
<head>
    <title>Your Student Information</title>
</head>
<body bgcolor="#D9DFAA">
<table width="400" border=1>
    <caption>Your Student Information：</caption>
    <tr>
        <th>Student ID</th>
        <th>Student Name</th>
        <th>Department</th>
        <th>Total Credit</th>
    </tr>
    <c:forEach var="value" items="${instructorstudentlist}">
        <tr>
            <td align="center">${value.getId()}</td>
            <td align="center">${value.getName()}</td>
            <td align="center">${value.getDepartment().getDeptName()}</td>
            <td align="center">${value.getTotCred()}</td>
        </tr>
    </c:forEach>
</table>
<form action="\validate" method="get">
    <input type="submit" value="Back"/>
</form>
</body>
</html>