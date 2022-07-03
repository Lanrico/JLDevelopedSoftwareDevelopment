package com.example.demo.DAO;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.StudentTable;
import com.example.demo.model.UserTable;
public interface StudentTableDAO extends JpaRepository<StudentTable, Integer> {
	StudentTable save(StudentTable entity);
	void deleteById(Integer id);
}
