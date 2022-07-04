<html>
<head>
    <title>Instructor Page</title>
</head>
<body bgcolor="#E3E3E3">
Hello instructor <span>${username}</span>
<br>
<form action="\instructorInfo" method="get">
    <input type="submit" value="Instructor Information"/>
</form>
<br>
<form action="\instructorStudentInfo" method="get">
    <input type="submit" value="Your Student Information"/>
</form>
<br>
<form action="\instructorCourseManagement" method="get">
    <input type="submit" value="Instructor Course Management"/>
</form>
<br>
<form action="\updateinstructorInfo" method="get">
    <input type="submit" value="Change Instructor Password"/>
</form>
<br>
</body>
</html>