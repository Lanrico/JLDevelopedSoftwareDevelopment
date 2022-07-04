package com.example.demo.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "student", schema = "college", catalog = "")
public class StudentEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private String id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "tot_cred")
    private BigDecimal totCred;
    @Basic
    @Column(name = "password")
    private String password;

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

    public BigDecimal getTotCred() {
        return totCred;
    }

    public void setTotCred(BigDecimal totCred) {
        this.totCred = totCred;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToOne
    private DepartmentEntity dept;
    public DepartmentEntity getDepartment() {
        return dept;
    }
    public void setDepartment(DepartmentEntity dept) {
        this.dept = dept;
    }

    @ManyToOne
    @JoinTable(
            name = "advisor",
            joinColumns = @JoinColumn(name = "s_id"),
            inverseJoinColumns = @JoinColumn(name = "i_id")
    )
    private InstructorEntity instructor;
    public InstructorEntity getInstructors() {
        return instructor;
    }
    public void setInstructors(InstructorEntity instructor) {
        this.instructor = instructor;
    }

    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    @JoinTable(
            name = "takes",
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
