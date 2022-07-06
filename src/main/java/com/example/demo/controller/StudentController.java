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
public class StudentController {

	@RequestMapping("/login")
    public String login(){
        return "login"; 
    }

	@Autowired
	private StudentDAO studentDAO;
	@Autowired
	private InstructorDAO instructorDAO;
	@Autowired
	private CourseDAO courseDAO;
	@Autowired
	private SectionDAO sectionDAO;

    @RequestMapping("/validate")
    public String login(String ID, String password, HttpSession session) throws IOException {
		Object user=session.getAttribute("user");
		if(user!=null) {
			session.setAttribute("changePasswordValidate", "");
			try {
				StudentEntity user0 = (StudentEntity)user;
			}catch (ClassCastException e){
				return "instructorMain";
			}
			return "studentMain";
		}
		StudentEntity student= studentDAO.findStudentEntityByidAndPassword(ID, password);
		InstructorEntity instructor= instructorDAO.findInstructorEntityByidAndPassword(ID, password);
		session.setAttribute("userValidate",true);
		if(student==null && instructor == null)
		{
			session.setAttribute("userValidate",false);
			return "login";
		}
		else if(student==null){
			session.setAttribute("user", instructor);
			session.setAttribute("username", instructor.getName());
			return "instructorMain";
		}
		else {
			session.setAttribute("user", student);
			session.setAttribute("username", student.getName());
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
    	return "editstudent";
    }

    @RequestMapping("/updateStudent")
	public String updatestudent(String originPassword, String newPassword1, String newPassword2, HttpSession session) throws IOException{
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

	@RequestMapping("/courseInfo")
	public String courseInfo(HttpSession session) throws IOException {
		StudentEntity student=(StudentEntity) session.getAttribute("user");
		Set<SectionEntity> sectionlist = student.getSections();
		List<CourseEntity> courselist0 = courseDAO.findAll();
		List<CourseEntity> studentcourselist = courseDAO.findCourseEntitiesBySectionIn(sectionlist);
		List<CourseEntity> courselist = new ArrayList<>();
		for (CourseEntity entity : courselist0) {
			boolean flag = true;
			for (CourseEntity courseEntity : studentcourselist) {
				if (Objects.equals(entity.getCourseId(), courseEntity.getCourseId())) {
					flag = false;
					break;
				}
			}
			if (flag) courselist.add(entity);
		}
		session.setAttribute("allcourselist", courselist);
		return "allCourses";
	}

	@RequestMapping("/courseSelection")
	public String courseSelection(String courseId, HttpSession session) throws IOException {
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
		StudentEntity student=(StudentEntity) session.getAttribute("user");
		Set<SectionEntity> sectionlist= student.getSections();
		session.setAttribute("studentsectionlist", sectionlist);
		return "studentCourses";
	}

	@RequestMapping("/deleteCourse")
	public String deleteCourse(String courseId, HttpSession session) throws IOException {
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
}