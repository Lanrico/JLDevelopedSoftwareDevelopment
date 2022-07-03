package com.example.demo.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.DAO.*;
import com.example.demo.model.*;

@Controller
public class jspcontroller2 {
	@Autowired
	private UserTableDAO userDAO;
	@Autowired
	private StudentTableDAO studentDAO;
	@Autowired
	private MajorTableDAO majorDAO; 
	@Autowired
	private ClassTableDAO classDAO; 
	
	@RequestMapping("/courseInfo")
    public String studentInfo(HttpSession session) throws IOException {
    	List<String> coursenamelist=new ArrayList<String>();
    	List<ClassTable> courselist=classDAO.findAll();
    	for (int i = 0; i < courselist.size(); i++) {
    		coursenamelist.add(courselist.get(i).getClassname());
        }
    	session.setAttribute("coursenamelist", coursenamelist);
    	return "allCourses";  
    }  
	
    @RequestMapping("/courseSelection")
    public String courseSelection(String coursename, HttpSession session) throws IOException {	
    	UserTable user=(UserTable)session.getAttribute("user");
    	StudentTable stu=user.getStudent();
    	Set<ClassTable> courselist=(Set<ClassTable>)stu.getClasses();
    	Set<ClassTable> courselist1=new HashSet<ClassTable>();
    	for (Object obj: courselist) {
    		ClassTable course=(ClassTable)obj;
    		if(course.getClassname().equals(coursename))
    			return "allCourses";
    		courselist1.add(course);
        }
    	ClassTable course=classDAO.findByClassname(coursename);
    	stu.getClasses().clear();
    	courselist1.add(course);
    	stu.setClasses(courselist1);
    	studentDAO.save(stu);
		return "main";
	}
    
    @RequestMapping("/courseManagement")
    public String courseManagement(HttpSession session) throws IOException {
    	UserTable user=(UserTable)session.getAttribute("user");
    	StudentTable stu=user.getStudent();
    	Set<ClassTable> courselist=(Set<ClassTable>)stu.getClasses();
    	List<String> coursenamelist=new ArrayList<String>();
    	for (Object obj: courselist) {
    		ClassTable course=(ClassTable)obj;
    		coursenamelist.add(course.getClassname());
        }
    	session.setAttribute("studentcoursenamelist", coursenamelist);
    	return "studentCourses";  
    } 
    
    @RequestMapping("/deleteCourse")
    public String deleteCourse(String coursename, HttpSession session) throws IOException {	
    	UserTable user=(UserTable)session.getAttribute("user");
    	StudentTable stu=user.getStudent();
    	Set<ClassTable> courselist=(Set<ClassTable>)stu.getClasses();
    	Set<ClassTable> courselist1=new HashSet<ClassTable>();
    	for (Object obj: courselist) {
    		ClassTable course=(ClassTable)obj;
    		if(course.getClassname().equals(coursename))
    			continue;
    		courselist1.add(course);
        }
    	stu.getClasses().clear();
    	stu.setClasses(courselist1);
    	studentDAO.save(stu);
		return "main";
	}
    
    @RequestMapping("/deleteAccount")
    public String deleteAccount(HttpSession session) throws IOException {	
    	UserTable user=(UserTable)session.getAttribute("user");
    	StudentTable stu=user.getStudent();
    	stu.getClasses().clear();
    	studentDAO.save(stu);
    	studentDAO.delete(stu);
    	userDAO.delete(user);
    	session.setAttribute("user",null);
		return "login";
	}
}