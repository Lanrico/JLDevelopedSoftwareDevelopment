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
	private UserTableDAO0 userDAO;
	@Autowired
	private StudentDAO studentDAO;
	@Autowired
	private InstructorDAO instructorDAO;
	@Autowired
	private CourseDAO courseDAO;
	@Autowired
	private SectionDAO sectionDAO;

	@Autowired
	private StudentTableDAO0 studentTableDAO;
	@Autowired
	private MajorTableDAO0 majorDAO;
    @RequestMapping("/validate")
    public String login(String ID, String password, HttpSession session) throws IOException {
		System.out.println("1231231");
		Object user=session.getAttribute("user");
		if(user!=null) {
			try {
				StudentEntity user0 = (StudentEntity)user;
			}catch (ClassCastException e){
				return "instructorMain";
			}
//			if (studentDAO.findStudentEntityByidAndPassword(user0.getId(), user0.getPassword()) == null){
//				return "instructorMain";
//			}
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


}