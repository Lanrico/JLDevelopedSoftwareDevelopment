<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Course Management System</title>
</head>
Hello <span>${studentname}</span>
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
</html>
