package com.example.demo.DAO;

import com.example.demo.model.SectionEntity;
import com.example.demo.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface StudentDAO extends JpaRepository<StudentEntity, Integer> {
    StudentEntity findStudentEntityByidAndPassword(String ID, String password);
    List<StudentEntity> findAll();
    StudentEntity save(StudentEntity entity);
    List<StudentEntity> findStudentEntitiesBySectionIn(Set<SectionEntity> entity);
    List<StudentEntity> findStudentEntitiesByInstructor_Id(String ID);
}
