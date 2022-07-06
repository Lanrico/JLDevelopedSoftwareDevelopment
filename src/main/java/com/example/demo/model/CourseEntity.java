package com.example.demo.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "course", schema = "college", catalog = "")
public class CourseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "course_id")
    private String courseId;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "credits")
    private BigInteger credits;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigInteger getCredits() {
        return credits;
    }

    public void setCredits(BigInteger credits) {
        this.credits = credits;
    }

    @ManyToOne
    private DepartmentEntity dept;
    public DepartmentEntity getDepartment() {
        return dept;
    }
    public void setDepartment(DepartmentEntity dept) {
        this.dept = dept;
    }

    @OneToMany(mappedBy = "course")
    private Set<SectionEntity> section;
    public Set<SectionEntity> getSections() {
        return section;
    }
    public void setSections(Set<SectionEntity> section) {
        this.section = section;
    }

}
