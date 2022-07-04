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
	private StudentTableDAO0 studentDAO;
	@Autowired
	private MajorTableDAO0 majorDAO;
    @RequestMapping("/validate")
    public String login(String username, String password, HttpSession session) throws IOException {
		System.out.println("1231231");
    	UserTable0 user=(UserTable0)session.getAttribute("user");
    	if(user!=null)
    		return "main";
    	user=userDAO.findByUsernameAndPassword(username,password);
		if(user==null)
		{
			return "login";
		}
		session.setAttribute("user", user);
		session.setAttribute("studentname", user.getStudent().getStudentname());
		return "main";
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
    	studentDAO.save(stu);
        return "studentinfo";  
    }


    
}