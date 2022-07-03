package com.example.demo.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.*;
import com.example.demo.DAO.*;
@RestController
public class UserController {
	@Autowired
	private UserTableDAO userDAO;
	@Autowired
	private StudentTableDAO studentDAO;
	@Autowired
	private MajorTableDAO majorDAO;
	@Autowired
	private ClassTableDAO classDAO;
	@PostMapping("/user/validate")
	public void login(String username, String password, HttpSession session, HttpServletResponse response) throws IOException {	
		UserTable user=userDAO.findByUsernameAndPassword(username,password);
		if(user==null)
		{
			response.sendRedirect("http://localhost:8080/fail.html");
			return;
		}
		session.setAttribute("user", user);
		response.sendRedirect("http://localhost:8080/main.html");
	}
	@GetMapping("/adduser")
	public String addUser() {
		UserTable user=new UserTable();
		user.setUsername("new_user");
		user.setPassword("new_user");
		user.setStudent(new StudentTable());
		user.getStudent().setUser(user);
		user.getStudent().setStudentname("new_name");
		userDAO.save(user);
		return user.getStudent().getStudentname();
    }
	@GetMapping("/deleteuser")
	public String deleteUser() {
		UserTable user=userDAO.findByUsernameAndPassword("new_user","new_user");
		userDAO.delete(user);
		return "Delete Successful";
    }
	@GetMapping("/findallstudentsbymajor")
	public String findallstudentsbymajor() {
		MajorTable major=majorDAO.findByMajorname("SE");
		Iterator<StudentTable> it = major.getStudents().iterator();  
		String studentnames="";
		while (it.hasNext()) {  
		  studentnames += (it.next().getStudentname()+" ");   
		}  
		return studentnames;
    }
	@GetMapping("/findallstudentsbyclass")
	public String findallstudentsbyclass() {
		ClassTable c=classDAO.findByClassname("J2EE");
		Iterator<StudentTable> it = c.getStudents().iterator();  
		String studentnames="";
		while (it.hasNext()) {  
		  studentnames += (it.next().getStudentname()+" ");   
		}  
		return studentnames;
    }
/*	@RequestMapping("/")
	public void Hello(HttpServletResponse response, HttpSession session) throws IOException {
        if(session.getAttribute("user")!=null)
        	response.sendRedirect("http://localhost:8080/success.html");
        else
        	response.sendRedirect("http://localhost:8080/login.html");
    }*/
    @PostMapping("/user/register")
	public String register(String username, String password,
			String studentname, String gender, String dateofbirth, String age) {
		UserTable user=userDAO.findByUsernameAndPassword(username,password);
		if(user!=null)
		{
			return "Username and password exists";
		}
		user=new UserTable();
		user.setUsername(username);
		user.setPassword(password);
		user=userDAO.save(user);
		StudentTable student=new StudentTable();
		student.setId(user.getId());
		student.setStudentname(studentname);
		student.setGender(gender);
		student.setDateofbirth(dateofbirth);
		student.setAge(Integer.parseInt(age));
//		student.setUser(user);
		student=studentDAO.save(student);
		return "Registration Successful";
	}
	@PostMapping("/user/update")
	public String update(String username, String password,
			String studentname, String gender, String dateofbirth, String age, int major) {
		UserTable user=userDAO.findByUsernameAndPassword(username,password);
		if(user==null)
		{
			return "User does not exist";
		}
		StudentTable student=new StudentTable();
		student.setId(user.getId());
		student.setStudentname(studentname);
		student.setGender(gender);
		student.setDateofbirth(dateofbirth);
		student.setAge(Integer.parseInt(age));
		student=studentDAO.save(student);
		return "Update Successful";
	}
	@PostMapping("/user/delete")
	public String delete(String username, String password) {	
		UserTable user=userDAO.findByUsernameAndPassword(username,password);
		if(user==null)
		{
			return "User does not exist";
		}
		studentDAO.deleteById(user.getId());
		userDAO.deleteById(user.getId());
		return "Delete Successful";
	}
	@GetMapping("userAll")
	public List<UserTable> findAll() {
        System.out.println("查询所有数据:");
        return userDAO.findAll();
    }
}
