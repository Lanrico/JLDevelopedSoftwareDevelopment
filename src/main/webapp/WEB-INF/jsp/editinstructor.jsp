<%@ page language="java" pageEncoding="UTF-8"
         import="java.util.*, com.example.demo.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%
    //	UserTable0 user=(UserTable0)session.getAttribute("user");
//	StudentTable0 stu=user.getStudent();
//	String studentname=stu.getStudentname();
//	String gender=stu.getGender();
//	String dateofbirth=stu.getDateofbirth();
//	Integer age=stu.getAge();
//	MajorTable0 major=stu.getMajor();
//	String majorname=major.getMajorname();
//	List<String> majornamelist=(List<String>)session.getAttribute("majornamelist");

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
%>
<head>
    <title>Change Instructor Password</title>
</head>
<body bgcolor="#D9DFAA">
<form action="updateInstructor" method="post">
    <table>
        <tr>
            <td>Origin Password:</td>
            <td>
                <input type="password" name="originPassword" value="" />
            </td>
        </tr>
        <tr>
            <td>New Password:</td>
            <td>
                <input type="password" name="newPassword1" value="" />
            </td>
        </tr>
        <tr>
            <td>Reenter New Password:</td>
            <td>
                <input type="password" name="newPassword2" value="" />
            </td>
        </tr>
        <%--		<tr>--%>
        <%--			<td>Name:</td>--%>
        <%--			<td>--%>
        <%--				<input type="text" name="studentname" value="<%=studentname%>" />--%>
        <%--			</td>--%>
        <%--		</tr>--%>
        <%--		<tr>--%>
        <%--			<td>Name:</td>--%>
        <%--			<td>--%>
        <%--				<input type="text" name="gender" value="<%=gender%>" />--%>
        <%--			</td>--%>
        <%--		</tr>--%>
        <%--		<tr>--%>
        <%--			<td>Date of Birth:</td>--%>
        <%--			<td>--%>
        <%--				<input type="text" name="dateofbirth" value="<%=dateofbirth%>"/>--%>
        <%--			</td>--%>
        <%--		</tr>--%>
        <%--		<tr>--%>
        <%--			<td>Age:</td>--%>
        <%--			<td>--%>
        <%--				<input type="text" name="age" value="<%=age%>" />--%>
        <%--			</td>--%>
        <%--		</tr>--%>
        <%--		<tr> --%>
        <%--            <td>Major：</td>--%>
        <%--            <td><select id="majorname" name="majorname">  --%>
        <%--                                <c:forEach var="value" items="${majornamelist}">  --%>
        <%--                                <option value="${value}">  --%>
        <%--                                ${value}  --%>
        <%--                                </option>  --%>
        <%--                                </c:forEach>  --%>
        <%--                              </select>  --%>
        <%--            </td>--%>
        <%--        </tr>                  --%>
    </table>
    <p style="color: red"><%=errorContext%></p>
    <input type="submit" value="submit"/>
</form>
<form action="\validate" method="get">
    <input type="submit" value="Back"/>
</form>
</body>
</html>