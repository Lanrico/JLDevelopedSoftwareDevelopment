package com.example.demo.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "instructor", schema = "college", catalog = "")
public class InstructorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private String id;
    @Basic
    @Column(name = "name")
    private String name;
//    @Basic
//    @Column(name = "dept_name")
//    private String deptName;
    @Basic
    @Column(name = "salary")
    private BigDecimal salary;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getDeptName() {
//        return deptName;
//    }
//
//    public void setDeptName(String deptName) {
//        this.deptName = deptName;
//    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @ManyToOne
    private DepartmentEntity dept;
    public DepartmentEntity getDepartment() {
        return dept;
    }
    public void setDepartment(DepartmentEntity dept) {
        this.dept = dept;
    }

    @OneToMany(mappedBy = "instructor")
    private Set<StudentEntity> student;
    public Set<StudentEntity> getStudents() {
        return student;
    }
    public void setStudents(Set<StudentEntity> section) {
        this.student = student;
    }

    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    @JoinTable(
            name = "teaches",
            joinColumns = @JoinColumn(name = "ID"),
            inverseJoinColumns = {@JoinColumn(name = "year"), @JoinColumn(name = "semester"), @JoinColumn(name = "sec_id"), @JoinColumn(name = "course_id")}
    )
    private Set<SectionEntity> section;
    public Set<SectionEntity> getSections() {
        return section;
    }
    public void setSections(Set<SectionEntity> section) {
        this.section = section;
    }

}