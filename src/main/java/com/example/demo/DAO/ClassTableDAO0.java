package com.example.demo.DAO;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.ClassTable0;

public interface ClassTableDAO0 extends JpaRepository<ClassTable0, Integer> {
	ClassTable0 findByClassname(String classname);
	List<ClassTable0> findAll();
}

