<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Student Page</title>
</head>
<body bgcolor="#E3E3E3">

Hello <span>${username}</span>
<br>
<form action="\studentInfo" method="get">
    <input type="submit" value="Personal Information"/>
</form>
<br>
<form action="\updatestudentInfo" method="get">
    <input type="submit" value="Update Personal Information"/>
</form>
<br>
<form action="\courseInfo" method="get">
    <input type="submit" value="Course Information"/>
</form>
<br>
<form action="\courseManagement" method="get">
    <input type="submit" value="Course Management"/>
</form>
<br>
<a href="/deleteAccount"
   onClick="if(!confirm('Confirm deletion？'))return false;else return true;">
    Delete Current Account</a>
<br>

</body>
</html>