package com.example.demo.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "section", schema = "college", catalog = "")
@IdClass(SectionEntityPK.class)
public class SectionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "course_id")
    private String courseId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "sec_id")
    private String secId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "semester")
    private String semester;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "year")
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

    @ManyToOne
    private CourseEntity course;
    public CourseEntity getCourse() {
        return course;
    }
    public void setCourse(CourseEntity course) {
        this.course = course;
    }

    @ManyToOne
    private ClassroomEntity classroom;
    public ClassroomEntity getClassroom() {
        return classroom;
    }
    public void setClassroom(ClassroomEntity classroom) {
        this.classroom = classroom;
    }

    @ManyToOne
    private TimeSlotEntity timeSlot;
    public TimeSlotEntity getTimeSlot() {
        return timeSlot;
    }
    public void setTimeSlot(TimeSlotEntity timeSlot) {
        this.timeSlot = timeSlot;
    }

    @ManyToMany(mappedBy = "section", fetch = FetchType.EAGER)
    private Set<StudentEntity> students;
    public Set<StudentEntity> getStudents() {
        return students;
    }
    public void setStudents(Set<StudentEntity> students) {
        this.students = students;
    }

    @ManyToMany(mappedBy = "section", fetch = FetchType.EAGER)
    private Set<InstructorEntity> instructor;
    public Set<InstructorEntity> getInstructors() {
        return instructor;
    }
    public void setInstructors(Set<InstructorEntity> instructor) {
        this.instructor = instructor;
    }

}
