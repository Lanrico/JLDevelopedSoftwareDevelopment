<%@ page language="java" pageEncoding="UTF-8"
import="java.util.*, com.example.demo.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%
	UserTable user=(UserTable)session.getAttribute("user");
	StudentTable stu=user.getStudent();
	String studentname=stu.getStudentname();
	String gender=stu.getGender();
	String dateofbirth=stu.getDateofbirth();
	Integer age=stu.getAge();
	MajorTable major=stu.getMajor();
	String majorname=major.getMajorname();
	List<String> majornamelist=(List<String>)session.getAttribute("majornamelist");
%>
<head>
	<title>Edit Student Information</title>
</head>
<body bgcolor="#D9DFAA">
	<form action="updateStudent" method="post">
	<table>
		<tr>
			<td>Name:</td>
			<td>
				<input type="text" name="studentname" value="<%=studentname%>" />
			</td>
		</tr>
		<tr>
			<td>Name:</td>
			<td>
				<input type="text" name="gender" value="<%=gender%>" />
			</td>
		</tr>
		<tr>
			<td>Date of Birth:</td>
			<td>
				<input type="text" name="dateofbirth" value="<%=dateofbirth%>"/>
			</td>
		</tr>
		<tr>
			<td>Age:</td>
			<td>
				<input type="text" name="age" value="<%=age%>" />
			</td>
		</tr>
		<tr> 
            <td>Major：</td>
            <td><select id="majorname" name="majorname">  
                                <c:forEach var="value" items="${majornamelist}">  
                                <option value="${value}">  
                                ${value}  
                                </option>  
                                </c:forEach>  
                              </select>  
            </td>
        </tr>                  
	</table>
	<input type="submit" value="submit"/>
	</form>
	<form action="\validate" method="get">
		<input type="submit" value="Back"/>
	</form>
</body>
</html>