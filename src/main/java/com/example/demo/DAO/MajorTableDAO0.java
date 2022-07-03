package com.example.demo.DAO;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.MajorTable0;

public interface MajorTableDAO0 extends JpaRepository<MajorTable0, Integer> {
	MajorTable0 findByMajorname(String majorname);
	List<MajorTable0> findAll();
}
