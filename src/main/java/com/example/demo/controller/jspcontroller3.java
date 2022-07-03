package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.DAO.*;
import com.example.demo.model.*;

@Controller
public class jspcontroller3 {

    @RequestMapping("/registration")
    public String registration(){
        return "registration";
    }


    @Autowired
    private UserTableDAO0 userDAO;
    @Autowired
    private StudentTableDAO0 studentDAO;
    @Autowired
    private MajorTableDAO0 majorDAO;

    @PostMapping("/register")
    public String register(String username, String password,
                           String studentname, String gender, String dateofbirth, String age) {
        UserTable0 user=userDAO.findByUsernameAndPassword(username,password);
        if(user!=null)
        {
            return "Username and password exists";
        }
        System.out.println("123123123");
        user=new UserTable0();
        user.setUsername(username);
        user.setPassword(password);
        user=userDAO.save(user);
        StudentTable0 student=new StudentTable0();
        student.setId(user.getId());
        student.setStudentname(studentname);
        student.setGender(gender);
        student.setDateofbirth(dateofbirth);
        student.setAge(Integer.parseInt(age));
        student=studentDAO.save(student);
        return "Registration Successful";
    }

}