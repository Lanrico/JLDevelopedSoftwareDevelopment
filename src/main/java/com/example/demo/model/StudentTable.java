//package com.example.demo.model;
//import java.util.Set;
//
//import javax.persistence.*;
//import org.hibernate.annotations.GenericGenerator;
//@Entity
//@Table(name="student")
//public class StudentTable {
//    @GenericGenerator(name = "generator", strategy = "increment")
//    @Id
//    @GeneratedValue(generator = "generator")
//    private Integer stu_id;
//    @Column(name = "id")
//    private String stu_name;
//    @Column(name = "name")
//    private String stu_dept_name;
//    @Column(name = "dept_name")
//    private String stu_tot_cred;
//    @Column(name = "tot_cred")
//    private String stu_password;
//    @Column(name = "password")
//
//    @ManyToOne
//    private MajorTable0 major;
//    public MajorTable0 getMajor() {
//        return major;
//    }
//    public void setMajor(MajorTable0 major) {
//        this.major = major;
//    }
//
//    public Integer getStu_id() {
//        return stu_id;
//    }
//
//    public void setStu_id(Integer stu_id) {
//        this.stu_id = stu_id;
//    }
//
//    public String getStu_name() {
//        return stu_name;
//    }
//
//    public void setStu_name(String stu_name) {
//        this.stu_name = stu_name;
//    }
//
//    public String getStu_dept_name() {
//        return stu_dept_name;
//    }
//
//    public void setStu_dept_name(String stu_dept_name) {
//        this.stu_dept_name = stu_dept_name;
//    }
//
//    public String getStu_tot_cred() {
//        return stu_tot_cred;
//    }
//
//    public void setStu_tot_cred(String stu_tot_cred) {
//        this.stu_tot_cred = stu_tot_cred;
//    }
//
//    public String getStu_password() {
//        return stu_password;
//    }
//
//    public void setStu_password(String stu_password) {
//        this.stu_password = stu_password;
//    }
//}
