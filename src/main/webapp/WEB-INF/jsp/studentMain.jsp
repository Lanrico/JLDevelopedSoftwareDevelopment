<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<head>
    <title>Student Page</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/all.css" rel="stylesheet" type="text/css">
    <script src="https://cdn.staticfile.org/twitter-bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="mainContainer">
    <h2>Hello student <span>${username}</span></h2>
    <br>
    <div class="d-grid gap-4">
        <a class="btn btn-outline-dark" href="\studentInfo">Student Information</a>
        <a class="btn btn-outline-dark" href="\studentCourseManagement">Student Course Management</a>
        <a class="btn btn-outline-dark" href="\courseInfo">Select Other Courses</a>
        <a class="btn btn-outline-dark" href="\updatestudentInfo">Change Student Password</a>
    </div>
</div>
</body>
</html>