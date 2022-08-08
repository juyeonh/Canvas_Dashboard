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

	public void updateUserStatusById(int id) {		// set status to 1 (meaning that it's registered user)
		userDAO.updateUserStatusById(id);
	}

	public void addUser(String computingId, String password, String name, String email, String type, int status) {
		userDAO.insertUser(computingId, password, name, email, type, status);
	}

}
