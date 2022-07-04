<%@ page language="java" pageEncoding="UTF-8"
         import="java.util.*, com.example.demo.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%
    Set<SectionEntity> instructorsectionlist =(Set<SectionEntity>)session.getAttribute("instructorsectionlist");
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
    <c:forEach var="value" items="${instructorsectionlist}">
        <tr>
            <td align="center">${value.getCourse().getCourseId()}</td>
            <td align="center">${value.getCourse().getTitle()}</td>
            <td align="center">${value.getCourse().getCredits()}</td>
            <td align="center">${value.getCourse().getDepartment().getDeptName()}</td>
            <td align="center">${value.getClassroom().getBuilding()}</td>
            <td align="center">${value.getClassroom().getRoomNumber()}</td>
            <td align="center">${value.getClassroom().getCapacity()}</td>
            <td align="center">
                <a href="/studentSelectedSection?secId=${value.getSecId()}&courseId=${value.getCourseId()}&semester=${value.getSemester()}&year=${value.getYear()}">Check students</a>
            </td>
        </tr>
    </c:forEach>
</table>
<form action="\validate" method="get">
    <input type="submit" value="Back"/>
</form>
<br>
</body>
</html>