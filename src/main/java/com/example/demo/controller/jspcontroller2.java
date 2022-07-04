package com.example.demo.controller;

import java.io.IOException;
import java.util.*;

import javax.persistence.NonUniqueResultException;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.DAO.*;
import com.example.demo.model.*;

@Controller
public class jspcontroller2 {
	@Autowired
	private UserTableDAO0 userDAO;
	@Autowired
	private StudentDAO studentDAO;
	@Autowired
	private StudentTableDAO0 studentTableDAO;
	@Autowired
	private MajorTableDAO0 majorDAO;
	@Autowired
	private ClassTableDAO0 classDAO;
	@Autowired
	private CourseDAO courseDAO;
	@Autowired
	private SectionDAO sectionDAO;
	@RequestMapping("/courseInfo")
    public String courseInfo(HttpSession session) throws IOException {
//    	List<String> coursenamelist=new ArrayList<String>();
//    	List<ClassTable0> courselist=classDAO.findAll();
//    	for (int i = 0; i < courselist.size(); i++) {
//    		coursenamelist.add(courselist.get(i).getClassname());
//        }
//    	session.setAttribute("coursenamelist", coursenamelist);
//		StudentEntity student=(StudentEntity) session.getAttribute("user");
//		Set<SectionEntity> sectionlist= student.getSections();
//		Set<CourseEntity> courselist = new HashSet<>();
//		for (SectionEntity a: sectionlist) {
//			courselist.add(a.getCourse());
//		}
		List<CourseEntity> courselist=courseDAO.findAll();

		session.setAttribute("allcourselist", courselist);
		return "allCourses";
    }  
	
    @RequestMapping("/courseSelection")
    public String courseSelection(String courseId, HttpSession session) throws IOException {
//    	UserTable0 user=(UserTable0)session.getAttribute("user");
//    	StudentTable0 stu=user.getStudent();
//    	Set<ClassTable0> courselist=(Set<ClassTable0>)stu.getClasses();
//    	Set<ClassTable0> courselist1=new HashSet<ClassTable0>();
//    	for (Object obj: courselist) {
//    		ClassTable0 course=(ClassTable0)obj;
//    		if(course.getClassname().equals(courseId))
//    			return "allCourses";
//    		courselist1.add(course);
//        }
//    	ClassTable0 course=classDAO.findByClassname(courseId);
//    	stu.getClasses().clear();
//    	courselist1.add(course);
//    	stu.setClasses(courselist1);
//    	studentTableDAO.save(stu);

		StudentEntity student=(StudentEntity) session.getAttribute("user");
		Set<SectionEntity> sectionlist=(Set<SectionEntity>)student.getSections();
		Set<SectionEntity> sectionlist1=new HashSet<SectionEntity>();
		for (SectionEntity obj: sectionlist) {
			if(obj.getCourse().getCourseId().equals(courseId))
				return "allCourses";
			sectionlist1.add(obj);
		}
		CourseEntity course = courseDAO.findByCourseId(courseId);
		student.getSections().clear();
		try{
			sectionlist1.add(sectionDAO.findSectionEntitiesByCourseId(courseId));
		}catch (NonUniqueResultException e){
			System.out.println("The section of Course ID" + courseId + "not found");
		}
		student.setSections(sectionlist1);
		studentDAO.save(student);
		return "studentMain";
	}
    
    @RequestMapping("/studentCourseManagement")
    public String studentCourseManagement(HttpSession session) throws IOException {
//    	UserTable0 user=(UserTable0)session.getAttribute("user");
//    	StudentTable0 stu=user.getStudent();
//    	Set<ClassTable0> courselist=(Set<ClassTable0>)stu.getClasses();
//    	List<String> coursenamelist=new ArrayList<String>();
//    	for (Object obj: courselist) {
//    		ClassTable0 course=(ClassTable0)obj;
//    		coursenamelist.add(course.getClassname());
//        }
//    	session.setAttribute("studentcoursenamelist", coursenamelist);
		StudentEntity student=(StudentEntity) session.getAttribute("user");
		Set<SectionEntity> sectionlist= student.getSections();
//		Set<CourseEntity> courselist = new HashSet<>();
//		for (SectionEntity a: sectionlist) {
//			courselist.add(a.getCourse());
//		}
    	session.setAttribute("studentsectionlist", sectionlist);
		return "studentCourses";
    } 
    
    @RequestMapping("/deleteCourse")
    public String deleteCourse(String courseId, HttpSession session) throws IOException {
//    	UserTable0 user=(UserTable0)session.getAttribute("user");
//    	StudentTable0 stu=user.getStudent();
//    	Set<ClassTable0> courselist=(Set<ClassTable0>)stu.getClasses();
//    	Set<ClassTable0> courselist1=new HashSet<ClassTable0>();
//    	for (Object obj: courselist) {
//    		ClassTable0 course=(ClassTable0)obj;
//    		if(course.getClassname().equals(coursename))
//    			continue;
//    		courselist1.add(course);
//        }
//    	stu.getClasses().clear();
//    	stu.setClasses(courselist1);
//    	studentDAO.save(stu);

		StudentEntity student=(StudentEntity) session.getAttribute("user");
		Set<SectionEntity> sectionlist=(Set<SectionEntity>)student.getSections();
		Set<SectionEntity> sectionlist1=new HashSet<SectionEntity>();
		for (SectionEntity obj: sectionlist) {
			if(obj.getCourse().getCourseId().equals(courseId))
				continue;
			sectionlist1.add(obj);
		}
		student.getSections().clear();
		student.setSections(sectionlist1);
		studentDAO.save(student);
		return "studentMain";
	}
    
    @RequestMapping("/deleteAccount")
    public String deleteAccount(HttpSession session) throws IOException {	
    	UserTable0 user=(UserTable0)session.getAttribute("user");
    	StudentTable0 stu=user.getStudent();
    	stu.getClasses().clear();
    	studentTableDAO.save(stu);
    	studentTableDAO.delete(stu);
    	userDAO.delete(user);
    	session.setAttribute("user",null);
		return "login";
	}
}