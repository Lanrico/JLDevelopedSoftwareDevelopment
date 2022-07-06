<!DOCTYPE html>
<head>
    <title>Login</title>
    <%
        Boolean userValidate = (Boolean) session.getAttribute("userValidate");
        String errorContext = "";
        if (userValidate != null) if (!userValidate) errorContext = "Wrong ID or password";
        System.out.println(userValidate);
        String errorDisplay = "none";
        if (userValidate != null) if (!userValidate) errorDisplay = "block";

    %>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/all.css" rel="stylesheet" type="text/css">
    <script src="https://cdn.staticfile.org/twitter-bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</head>
<body bgcolor="#E3E3E3">
<div class="row main-row">
    <div class="col"></div>
    <div class="col">
        <form class="loginForm" action="\validate" method="post">
            <h2>User Login</h2>
            <div class="form-group">
                <label>ID:</label>
                <input type="text" class="form-control" name="ID" size="20"/>
            </div>
            <br>
            <div class="form-group">
                <label>Password:</label>
                <input type="password" class="form-control" name="password" size="20"/>
            </div>
            <input type="submit" value="Login" class="btn btn-outline-primary" id="login-button"/>
            <input type="reset" value="Reset" class="btn btn-outline-secondary" id="reset-button"/>
<%--            <p style="color: red"><%=errorContext%></p>--%>
            <div class="alert alert-danger alert-dismissible" style="display: <%=errorDisplay%>">
                <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                <strong>Error!</strong> Wrong ID or password.
            </div>
<%--            <p style="display: <%=errorDisplay%> ;color: red">Wrong ID or password</p>--%>
        </form>
    </div>
    <div class="col"></div>
</div>
</body>
</html>