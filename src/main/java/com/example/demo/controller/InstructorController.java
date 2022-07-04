package com.example.demo.controller;

import com.example.demo.DAO.InstructorDAO;
import com.example.demo.DAO.SectionDAO;
import com.example.demo.DAO.StudentDAO;
import com.example.demo.model.InstructorEntity;
import com.example.demo.model.SectionEntity;
import com.example.demo.model.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Controller
public class InstructorController {
    @Autowired
    private InstructorDAO instructorDAO;
    @Autowired
    private SectionDAO sectionDAO;
    @Autowired
    private StudentDAO studentDAO;

    @RequestMapping("/instructorInfo")
    public String instructorInfo(HttpSession session){
//        InstructorEntity instructor=(InstructorEntity) session.getAttribute("user");
//        List<StudentEntity> studentlist = studentDAO.findStudentEntitiesByInstructor_Id(instructor.getId());
////		Set<CourseEntity> courselist = new HashSet<>();
////		for (SectionEntity a: sectionlist) {
////			courselist.add(a.getCourse());
////		}
//        session.setAttribute("instructorstudentlist", studentlist);
        return "instructorinfo";
    }
    @RequestMapping("/instructorStudentInfo")
    public String instructorStudentInfo(HttpSession session){
        InstructorEntity instructor=(InstructorEntity) session.getAttribute("user");
        List<StudentEntity> studentlist = studentDAO.findStudentEntitiesByInstructor_Id(instructor.getId());
//		Set<CourseEntity> courselist = new HashSet<>();
//		for (SectionEntity a: sectionlist) {
//			courselist.add(a.getCourse());
//		}
        session.setAttribute("instructorstudentlist", studentlist);
        return "instructorstudents";
    }

    @RequestMapping("/instructorCourseManagement")
    public String instructorCourseManagement(HttpSession session) throws IOException {
//    	UserTable0 user=(UserTable0)session.getAttribute("user");
//    	StudentTable0 stu=user.getStudent();
//    	Set<ClassTable0> courselist=(Set<ClassTable0>)stu.getClasses();
//    	List<String> coursenamelist=new ArrayList<String>();
//    	for (Object obj: courselist) {
//    		ClassTable0 course=(ClassTable0)obj;
//    		coursenamelist.add(course.getClassname());
//        }
//    	session.setAttribute("studentcoursenamelist", coursenamelist);
        InstructorEntity instructor=(InstructorEntity) session.getAttribute("user");
        Set<SectionEntity> sectionlist= instructor.getSections();
//		Set<CourseEntity> courselist = new HashSet<>();
//		for (SectionEntity a: sectionlist) {
//			courselist.add(a.getCourse());
//		}
        session.setAttribute("instructorsectionlist", sectionlist);
        return "instructorCourses";
    }
    @RequestMapping("/studentSelectedSection")
    public String studentSelectedSection(String secId, String courseId, String semester, BigDecimal year, HttpSession session) throws IOException {
//    	UserTable0 user=(UserTable0)session.getAttribute("user");
//    	StudentTable0 stu=user.getStudent();
//    	Set<ClassTable0> courselist=(Set<ClassTable0>)stu.getClasses();
//    	List<String> coursenamelist=new ArrayList<String>();
//    	for (Object obj: courselist) {
//    		ClassTable0 course=(ClassTable0)obj;
//    		coursenamelist.add(course.getClassname());
//        }
//    	session.setAttribute("studentcoursenamelist", coursenamelist);
        Set<SectionEntity> sectionlist = new HashSet<>();
        sectionlist.add(sectionDAO.findBySecIdAndCourseIdAndSemesterAndYear(secId, courseId, semester, year));
        List<StudentEntity> studentlist = studentDAO.findStudentEntitiesBySectionIn(sectionlist);
//		Set<CourseEntity> courselist = new HashSet<>();
//		for (SectionEntity a: sectionlist) {
//			courselist.add(a.getCourse());
//		}
        session.setAttribute("coursestudentlist", studentlist);
        return "studentSelectedCourse";
    }
    @RequestMapping("/updateinstructorInfo")
    public String updateinstructorInfo(HttpSession session) throws IOException{
//    	List<String> majornamelist=(List<String>)session.getAttribute("majornamelist");
//    	if(majornamelist!=null)
//    		return "editstudent";
//    	List<MajorTable0> majorlist=majorDAO.findAll();
//    	majornamelist=new ArrayList<String>();
//    	for (int i = 0; i < majorlist.size(); i++) {
//            majornamelist.add(majorlist.get(i).getMajorname());
//        }
//    	session.setAttribute("majornamelist", majornamelist);
        return "editinstructor";
    }

    @RequestMapping("/updateInstructor")
//	public String updatestudent(String studentname, String gender,
//								String dateofbirth, String age, String majorname, HttpSession session) throws IOException{
    public String updateInstructor(String originPassword, String newPassword1, String newPassword2, HttpSession session) throws IOException{
//    	UserTable0 user=(UserTable0)session.getAttribute("user");
//    	StudentTable0 stu=user.getStudent();
//    	stu.setStudentname(studentname);
//    	stu.setGender(gender);
//    	stu.setDateofbirth(dateofbirth);
//    	stu.setAge(Integer.parseInt(age));
//    	MajorTable0 major=majorDAO.findByMajorname(majorname);
//    	stu.setMajor(major);

        InstructorEntity instructor = (InstructorEntity)session.getAttribute("user");
        if(!Objects.equals(originPassword, instructor.getPassword())){
            session.setAttribute("changePasswordValidate", "ErrorOriginPassword");
            return "editinstructor";
        }
        else if(!Objects.equals(newPassword1, newPassword2)){
            session.setAttribute("changePasswordValidate", "DifferentReenter");
            return "editinstructor";
        }
        else{
            session.setAttribute("changePasswordValidate", "");
            instructor.setPassword(newPassword1);
            instructorDAO.save(instructor);
            return "instructorinfo";
        }
    }


}
