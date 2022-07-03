package com.example.demo.model;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="classtable")
public class ClassTable0 {
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	private Integer id;
	@Column(name = "classname")
	private String classname;
	
	
	@ManyToMany(mappedBy = "classes", fetch = FetchType.EAGER)
	private Set<StudentTable0> students;
	public Set<StudentTable0> getStudents() {
		return students;
	}
	public void setStudents(Set<StudentTable0> students) {
		this.students = students;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	
}
