package com.example.demo.DAO;

import com.example.demo.model.CourseEntity;
import com.example.demo.model.InstructorEntity;
import com.example.demo.model.SectionEntity;
import com.example.demo.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseDAO extends JpaRepository<CourseEntity, Integer> {
    List<CourseEntity> findAll();
    CourseEntity save(CourseEntity entity);
    CourseEntity findByCourseId(String ID);
}