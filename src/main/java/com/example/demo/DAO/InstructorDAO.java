package com.example.demo.DAO;

import com.example.demo.model.InstructorEntity;
import com.example.demo.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstructorDAO extends JpaRepository<InstructorEntity, Integer> {
    InstructorEntity findInstructorEntityByidAndPassword(String ID, String password);
    List<InstructorEntity> findAll();
    InstructorEntity save(InstructorEntity entity);
}