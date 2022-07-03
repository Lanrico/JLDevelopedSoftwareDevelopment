package com.example.demo.DAO;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.ClassTable;
import com.example.demo.model.MajorTable;
public interface ClassTableDAO extends JpaRepository<ClassTable, Integer> {
	ClassTable findByClassname(String classname);
	List<ClassTable> findAll();
}

