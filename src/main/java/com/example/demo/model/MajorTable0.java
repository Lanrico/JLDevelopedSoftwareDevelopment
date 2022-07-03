package com.example.demo.model;
import java.util.Set;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="majortable")
public class MajorTable0 {
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	private Integer id;
	@Column(name = "majorname")
	private String majorname;
	
	@OneToMany(mappedBy = "major")
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

	public String getMajorname() {
		return majorname;
	}

	public void setMajorname(String majorname) {
		this.majorname = majorname;
	}

	
	
	
}
