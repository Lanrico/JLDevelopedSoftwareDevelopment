package com.example.demo.DAO;

import com.example.demo.model.StudentEntity;
import com.example.demo.model.UserTable0;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentDAO extends JpaRepository<StudentEntity, Integer> {
    StudentEntity findStudentEntityByidAndPassword(String ID, String password);
    List<StudentEntity> findAll();
    StudentEntity save(StudentEntity entity);
    void deleteById(String id);
}
