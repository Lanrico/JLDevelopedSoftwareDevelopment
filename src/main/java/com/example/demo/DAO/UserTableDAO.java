package com.example.demo.DAO;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.StudentTable;
import com.example.demo.model.UserTable;
public interface UserTableDAO extends JpaRepository<UserTable, Integer> {
	UserTable findByUsernameAndPassword(String username,String password);
	List<UserTable> findAll();
	UserTable save(UserTable entity);
	void deleteById(Integer id);
}
