<%@ page language="java" pageEncoding="UTF-8"
import="java.util.*, com.example.demo.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%
	String changePasswordValidate=(String)session.getAttribute("changePasswordValidate");
	String errorContext = "";
	System.out.println(changePasswordValidate);
	if (changePasswordValidate == null){
		errorContext = "";
	}
	else if(changePasswordValidate.equals("DifferentReenter")){
		errorContext = "The two entered passwords do not match";
	}
	else if(changePasswordValidate.equals("ErrorOriginPassword")){
		errorContext = "You enter the wrong origin password";
	}
	String errorDisplay = "none";
	if (changePasswordValidate != null) if (!changePasswordValidate.equals("")) errorDisplay = "block";
%>
<head>
	<title>Change Student Password</title>
	<link href="https://cdn.staticfile.org/twitter-bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
	<link href="css/all.css" rel="stylesheet" type="text/css">
	<script src="https://cdn.staticfile.org/twitter-bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="mainContainer">
	<form action="updateStudent" method="post">
	<table class="table table-condensed">
		<tr>
			<td>Origin Password:</td>
			<td>
				<input class="form-control" type="password" name="originPassword" value="" />
			</td>
		</tr>
		<tr>
			<td>New Password:</td>
			<td>
				<input class="form-control" type="password" name="newPassword1" value="" />
			</td>
		</tr>
		<tr>
			<td>Reenter New Password:</td>
			<td>
				<input class="form-control" type="password" name="newPassword2" value="" />
			</td>
		</tr>
	</table>
		<input class="btn btn-outline-dark" type="submit" value="submit" id="login-button"/>
		<a class="btn btn-outline-dark" id="reset-button" href="/validate">Back</a>
	</form>
	<div class="alert alert-danger alert-dismissible" style="display: <%=errorDisplay%>">
		<button type="button" class="btn-close" data-bs-dismiss="alert"></button>
		<strong>Error!</strong> <%=errorContext%>
	</div>
</div>
</body>
</html>