package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.StudentTable0;

public interface StudentTableDAO0 extends JpaRepository<StudentTable0, Integer> {
	StudentTable0 save(StudentTable0 entity);
	void deleteById(Integer id);
}
