package com.example.demo.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.DAO.*;
import com.example.demo.model.*;

@Controller
public class jspcontroller {

	@RequestMapping("/login")
    public String login(){
        return "login"; 
    }


	@Autowired
	private UserTableDAO0 userDAO;
	@Autowired
	private StudentDAO studentDAO;
	@Autowired
	private InstructorDAO instructorDAO;
	@Autowired
	private StudentTableDAO0 studentTableDAO;
	@Autowired
	private MajorTableDAO0 majorDAO;
    @RequestMapping("/validate")
    public String login(String ID, String password, HttpSession session) throws IOException {
		System.out.println("1231231");
		Object user=session.getAttribute("user");
		if(user!=null) {
			StudentEntity user0 = (StudentEntity)user;
			if (studentDAO.findStudentEntityByidAndPassword(user0.getId(), user0.getPassword()) == null){
				return "instructorMain";
			}
			return "studentMain";
		}
//		user=userDAO.findByUsernameAndPassword(username,password);
//		if(user==null)
//		{
//			return "login";
//		}
//		session.setAttribute("user", user);
//		session.setAttribute("studentname", user.getStudent().getStudentname());
//		return "main";
		StudentEntity student= studentDAO.findStudentEntityByidAndPassword(ID, password);
		InstructorEntity instructor= instructorDAO.findInstructorEntityByidAndPassword(ID, password);
		if(student==null && instructor == null)
		{
			return "login";
		}
		else if(student==null){
			session.setAttribute("user", instructor);
			session.setAttribute("username", instructor.getName());
//			return "main"; //之后要改成区分学生和老师的
			return "instructorMain";
		}
		else {
			session.setAttribute("user", student);
			session.setAttribute("username", student.getName());
			//return "main";
			student = (StudentEntity) session.getAttribute("user");
			return "studentMain";
		}
	}
    @RequestMapping("/studentInfo")
    public String studentInfo(){
        return "studentinfo";  
    }
    @RequestMapping("/updatestudentInfo")
    public String updatestudentInfo(HttpSession session) throws IOException{
//    	List<String> majornamelist=(List<String>)session.getAttribute("majornamelist");
//    	if(majornamelist!=null)
//    		return "editstudent";
//    	List<MajorTable0> majorlist=majorDAO.findAll();
//    	majornamelist=new ArrayList<String>();
//    	for (int i = 0; i < majorlist.size(); i++) {
//            majornamelist.add(majorlist.get(i).getMajorname());
//        }
//    	session.setAttribute("majornamelist", majornamelist);
    	return "editstudent";  
    }
    @RequestMapping("/updateStudent")
//	public String updatestudent(String studentname, String gender,
//								String dateofbirth, String age, String majorname, HttpSession session) throws IOException{
	public String updatestudent(String originPassword, String newPassword1, String newPassword2, HttpSession session) throws IOException{
//    	UserTable0 user=(UserTable0)session.getAttribute("user");
//    	StudentTable0 stu=user.getStudent();
//    	stu.setStudentname(studentname);
//    	stu.setGender(gender);
//    	stu.setDateofbirth(dateofbirth);
//    	stu.setAge(Integer.parseInt(age));
//    	MajorTable0 major=majorDAO.findByMajorname(majorname);
//    	stu.setMajor(major);

		StudentEntity student = (StudentEntity)session.getAttribute("user");
		if(!Objects.equals(originPassword, student.getPassword())){
			session.setAttribute("changePasswordValidate", "ErrorOriginPassword");
			return "editstudent";
		}
		else if(!Objects.equals(newPassword1, newPassword2)){
			session.setAttribute("changePasswordValidate", "DifferentReenter");
			return "editstudent";
		}
		else{
			session.setAttribute("changePasswordValidate", "");
			student.setPassword(newPassword1);
			studentDAO.save(student);
			return "studentinfo";
		}
    }

}