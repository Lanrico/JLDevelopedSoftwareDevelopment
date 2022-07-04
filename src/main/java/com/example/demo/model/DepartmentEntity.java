package com.example.demo.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "department", schema = "college", catalog = "")
public class DepartmentEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "dept_name")
    private String deptName;
    @Basic
    @Column(name = "building")
    private String building;
    @Basic
    @Column(name = "budget")
    private BigDecimal budget;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    @OneToMany(mappedBy = "dept")
    private Set<StudentEntity> students;
    public Set<StudentEntity> getStudents() {
        return students;
    }
    public void setStudents(Set<StudentEntity> students) {
        this.students = students;
    }

    @OneToMany(mappedBy = "dept")
    private Set<InstructorEntity> instructors;
    public Set<InstructorEntity> getInstructors() {
        return instructors;
    }
    public void setInstructors(Set<InstructorEntity> instructors) {
        this.instructors = instructors;
    }

    @OneToMany(mappedBy = "dept")
    private Set<CourseEntity> course;
    public Set<CourseEntity> getCourses() {
        return course;
    }
    public void setCourses(Set<CourseEntity> course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentEntity that = (DepartmentEntity) o;
        return Objects.equals(deptName, that.deptName) && Objects.equals(building, that.building) && Objects.equals(budget, that.budget);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptName, building, budget);
    }
}
