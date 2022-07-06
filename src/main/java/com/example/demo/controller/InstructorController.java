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
        return "instructorinfo";
    }

    @RequestMapping("/instructorStudentInfo")
    public String instructorStudentInfo(HttpSession session){
        InstructorEntity instructor=(InstructorEntity) session.getAttribute("user");
        List<StudentEntity> studentlist = studentDAO.findStudentEntitiesByInstructor_Id(instructor.getId());
        session.setAttribute("instructorstudentlist", studentlist);
        return "instructorstudents";
    }

    @RequestMapping("/instructorCourseManagement")
    public String instructorCourseManagement(HttpSession session) throws IOException {
        InstructorEntity instructor=(InstructorEntity) session.getAttribute("user");
        Set<SectionEntity> sectionlist= instructor.getSections();
        session.setAttribute("instructorsectionlist", sectionlist);
        return "instructorCourses";
    }

    @RequestMapping("/studentSelectedSection")
    public String studentSelectedSection(String secId, String courseId, String semester, BigDecimal year, HttpSession session) throws IOException {
        Set<SectionEntity> sectionlist = new HashSet<>();
        sectionlist.add(sectionDAO.findBySecIdAndCourseIdAndSemesterAndYear(secId, courseId, semester, year));
        List<StudentEntity> studentlist = studentDAO.findStudentEntitiesBySectionIn(sectionlist);
        session.setAttribute("coursestudentlist", studentlist);
        return "studentSelectedCourse";
    }

    @RequestMapping("/updateinstructorInfo")
    public String updateinstructorInfo(HttpSession session) throws IOException{
        return "editinstructor";
    }

    @RequestMapping("/updateInstructor")
    public String updateInstructor(String originPassword, String newPassword1, String newPassword2, HttpSession session) throws IOException{
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
