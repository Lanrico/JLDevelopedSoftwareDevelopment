package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class SectionEntityPK implements Serializable {
    @Column(name = "course_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String courseId;
    @Column(name = "sec_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String secId;
    @Column(name = "semester")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String semester;
    @Column(name = "year")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigDecimal year;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getSecId() {
        return secId;
    }

    public void setSecId(String secId) {
        this.secId = secId;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public BigDecimal getYear() {
        return year;
    }

    public void setYear(BigDecimal year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SectionEntityPK that = (SectionEntityPK) o;
        return year == that.year && Objects.equals(courseId, that.courseId) && Objects.equals(secId, that.secId) && Objects.equals(semester, that.semester);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, secId, semester, year);
    }
}
