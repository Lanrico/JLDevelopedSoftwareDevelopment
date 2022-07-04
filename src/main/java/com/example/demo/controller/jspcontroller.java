package com.example.demo.controller;

import java.io.IOException;
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
//		UserTable0 user=(UserTable0)session.getAttribute("user");
//		if(user!=null)
//			return "main";
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
			return "main"; //之后要改成区分学生和老师的
		}
		else {
			session.setAttribute("user", student);
			session.setAttribute("username", student.getName());
			return "main";
		}
	}
    @RequestMapping("/studentInfo")
    public String studentInfo(){
        return "studentinfo";  
    }
    @RequestMapping("/updatestudentInfo")
    public String updatestudentInfo(HttpSession session) throws IOException{
    	List<String> majornamelist=(List<String>)session.getAttribute("majornamelist");
    	if(majornamelist!=null)
    		return "editstudent";  
    	List<MajorTable0> majorlist=majorDAO.findAll();
    	majornamelist=new ArrayList<String>();
    	for (int i = 0; i < majorlist.size(); i++) {
            majornamelist.add(majorlist.get(i).getMajorname());
        }
    	session.setAttribute("majornamelist", majornamelist);
    	return "editstudent";  
    }
    @RequestMapping("/updateStudent")
    public String updatestudent(String studentname, String gender,
    		String dateofbirth, String age, String majorname, HttpSession session) throws IOException{
    	UserTable0 user=(UserTable0)session.getAttribute("user");
    	StudentTable0 stu=user.getStudent();
    	stu.setStudentname(studentname);
    	stu.setGender(gender);
    	stu.setDateofbirth(dateofbirth);
    	stu.setAge(Integer.parseInt(age));
    	MajorTable0 major=majorDAO.findByMajorname(majorname);
    	stu.setMajor(major);
    	studentTableDAO.save(stu);
        return "studentinfo";  
    }


    
}