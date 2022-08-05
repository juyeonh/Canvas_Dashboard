package com.dashboard.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dashboard.user.dao.UserDAO;
import com.dashboard.user.model.User;

@Service
public class UserBO {
	
	@Autowired
	private UserDAO userDAO;

	public User getUserByComputingId(String computingId, String password) {
		return userDAO.selectUserByComputingId(computingId, password);
	}

}
