package com.example.demo.model;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="usertable")
public class UserTable {
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	private Integer id;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	
	@OneToOne(mappedBy = "user", cascade=CascadeType.ALL)
	private StudentTable student;
	public StudentTable getStudent() {
		return student;
	}
	public void setStudent(StudentTable student) {
		this.student = student;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
