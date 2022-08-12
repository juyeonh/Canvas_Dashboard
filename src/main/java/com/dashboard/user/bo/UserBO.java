package com.dashboard.user.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dashboard.course.bo.CourseBO;
import com.dashboard.user.dao.UserDAO;
import com.dashboard.user.model.User;

@Service
public class UserBO {
	
	@Autowired
	private CourseBO courseBO;
	
	@Autowired
	private UserDAO userDAO;
	
	public User getUserById(int id) {
		return userDAO.selectUserById(id);
	}
	
	public User getUserByComputingId(String computingId) {
		return userDAO.selectUserByComputingId(computingId);
	}

	public User getUserByComputingIdAndPassword(String computingId, String password) {
		return userDAO.selectUserByComputingIdAndPassword(computingId, password);
	}

	public void updateUserStatusById(int id) {		// set status to 1 (meaning that it's registered user)
		userDAO.updateUserStatusById(id);
	}

	public int addUser(String computingId, String password, String name, String email, String type, int status, String profileImagePath) {
		return userDAO.insertUser(computingId, password, name, email, type, status, profileImagePath);
	}
	
	public List<User> getInstructorListById(int depId) {
		List<Integer> instIdList = courseBO.getInstructorIdListByDepartmentId(depId);
		List<User> instList = new ArrayList<>();
		for (int i = 0; i < instIdList.size(); i++) {
			User user = getUserById(instIdList.get(i));
			instList.add(user);
		}
		
		return instList;
	}
	
}
