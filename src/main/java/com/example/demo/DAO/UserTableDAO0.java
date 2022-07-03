package com.example.demo.DAO;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.UserTable0;
public interface UserTableDAO0 extends JpaRepository<UserTable0, Integer> {
	UserTable0 findByUsernameAndPassword(String username, String password);
	List<UserTable0> findAll();
	UserTable0 save(UserTable0 entity);
	void deleteById(Integer id);
}
