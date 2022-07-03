package com.example.demo.DAO;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.MajorTable;
import com.example.demo.model.UserTable;
public interface MajorTableDAO extends JpaRepository<MajorTable, Integer> {
	MajorTable findByMajorname(String majorname);
	List<MajorTable> findAll();
}
