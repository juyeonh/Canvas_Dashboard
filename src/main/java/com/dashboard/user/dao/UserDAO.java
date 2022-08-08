package com.dashboard.user.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dashboard.user.model.User;

@Repository
public interface UserDAO {

	public User selectUserByComputingId(
			@Param("computingId") String computingId, 
			@Param("password") String password);

	public void updateUserStatusById(int id);
	
	public void insertUser(
			@Param("computingId") String computingId, 
			@Param("password") String password, 
			@Param("name") String name, 
			@Param("email") String email, 
			@Param("type") String type, 
			@Param("status") int status);
}
