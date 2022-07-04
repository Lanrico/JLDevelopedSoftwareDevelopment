<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Student Page</title>
</head>
<body bgcolor="#E3E3E3">

Hello student <span>${username}</span>
<br>
<form action="\studentInfo" method="get">
    <input type="submit" value="Student Information"/>
</form>
<br>
<form action="\studentCourseManagement" method="get">
    <input type="submit" value="Student Course Management"/>
</form>
<br>
<form action="\updatestudentInfo" method="get">
    <input type="submit" value="Change Student Password"/>
</form>
<br>

</body>
</html>