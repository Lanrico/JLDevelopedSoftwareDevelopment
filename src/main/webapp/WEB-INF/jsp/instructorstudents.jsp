<%@ page language="java" pageEncoding="UTF-8"
         import="java.util.*, com.example.demo.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%
    List<StudentEntity> instructorstudentlist=(List<StudentEntity>)session.getAttribute("instructorstudentlist");
%>
<head>
    <title>Your Student Information</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/all.css" rel="stylesheet" type="text/css">
    <script src="https://cdn.staticfile.org/twitter-bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="mainContainer tableContainer">
<table class="table table-striped">
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
    <input class="btn btn-outline-dark centerButton" type="submit" value="Back"/>
</form>
    </div>
</body>
</html>