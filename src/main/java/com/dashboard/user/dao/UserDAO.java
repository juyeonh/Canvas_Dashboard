package com.dashboard.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dashboard.user.model.User;

@Repository
public interface UserDAO {

	public User selectUserById(int id);

	public User selectUserByComputingId(String computingId);
	
	public User selectUserByComputingIdAndPassword(
			@Param("computingId") String computingId, 
			@Param("password") String password);

	public void updateUserStatusById(int id);
	
	public int insertUser(
			@Param("computingId") String computingId, 
			@Param("password") String password, 
			@Param("name") String name, 
			@Param("email") String email, 
			@Param("type") String type, 
			@Param("status") int status,
			@Param("profileImagePath") String profileImagePath);

//	public List<User> selectInstructorListByDepId(int depId);
	
}
