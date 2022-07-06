<!DOCTYPE html>
<head>
    <title>Instructor Page</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/all.css" rel="stylesheet" type="text/css">
    <script src="https://cdn.staticfile.org/twitter-bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="mainContainer">
    <h2>Hello instructor <span>${username}</span></h2>
    <br>
    <div class="d-grid gap-4">
        <a class="btn btn-outline-dark" href="\instructorInfo">Instructor Information</a>
        <a class="btn btn-outline-dark" href="\instructorStudentInfo">Your Student Information</a>
        <a class="btn btn-outline-dark" href="\instructorCourseManagement">Instructor Course Management</a>
        <a class="btn btn-outline-dark" href="\updateinstructorInfo">Change Instructor Password</a>
    </div>
</div>
</body>
</html>