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