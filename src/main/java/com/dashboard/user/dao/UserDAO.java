package com.dashboard.user.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dashboard.user.model.User;

@Repository
public interface UserDAO {

	public User selectUserByComputingId(
			@Param("computingId") String computingId, 
			@Param("password") String password);
	
}
