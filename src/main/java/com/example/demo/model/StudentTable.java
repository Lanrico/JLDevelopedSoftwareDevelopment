package com.example.demo.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="studenttable")
public class StudentTable {
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	private Integer id;
	@Column(name = "studentname")
	private String studentname;
	@Column(name = "gender")
	private String gender;
	@Column(name = "dateofbirth")
	private String dateofbirth;
	@Column(name = "age")
	private Integer age;
	
	@OneToOne
	private UserTable user;
	public UserTable getUser() {
		return user;
	}
	public void setUser(UserTable user) {
		this.user = user;
	}
	
	@ManyToOne
    private MajorTable major;	
	public MajorTable getMajor() {
		return major;
	}
	public void setMajor(MajorTable major) {
		this.major = major;
	}
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
	@JoinTable(
	  name = "student_class", 
	  joinColumns = @JoinColumn(name = "student_id"), 
	  inverseJoinColumns = @JoinColumn(name = "class_id"))
	private Set<ClassTable> classes;
	public Set<ClassTable> getClasses() {
		return classes;
	}
	public void setClasses(Set<ClassTable> classes) {
		this.classes = classes;
	}

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
}
