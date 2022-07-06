package com.example.demo.DAO;

import com.example.demo.model.CourseEntity;
import com.example.demo.model.InstructorEntity;
import com.example.demo.model.SectionEntity;
import com.example.demo.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface SectionDAO extends JpaRepository<SectionEntity, Integer> {
    List<SectionEntity> findAll();
    SectionEntity findSectionEntitiesByCourseId(String ID);
    SectionEntity findBySecIdAndCourseIdAndSemesterAndYear(String secId, String courseId, String semester, BigDecimal year);
}