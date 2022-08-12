package com.dashboard.course.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dashboard.course.dao.CourseDAO;
import com.dashboard.course.model.Course;
import com.dashboard.course.model.Department;

@Service
public class CourseBO {
	
	@Autowired
	private CourseDAO courseDAO;

	public int addDepartment(String departmentName) {
		return courseDAO.insertDepartment(departmentName);
	}
	
	public int addCourse(String name, int departmentId) {
		return courseDAO.insertCourse(name, departmentId);
	}
	
	public int addPrerequisite(int courseId, int reqCourseID) {
		return courseDAO.insertPrerequisite(courseId, reqCourseID);
	}
	
	public List<Department> getDepartmentList(){
		return courseDAO.selectDepartmentList();
	}
	
	public boolean checkDuplicateCourse(String courseName) {
		return courseDAO.checkDuplicateCourse(courseName);
	}
	
	public List<Course> getCourseListByDepartmentId(int departmentId){
		return courseDAO.selectCourseListByDepartmentId(departmentId);
	}

	public int addStudentProgram(Integer stuUserId, int departmentId, String type) {
		return courseDAO.insertStudentProgram(stuUserId, departmentId, type);
	}
	
	public int addInstructorProgram(Integer instUserId, int departmentId) {
		return courseDAO.insertInstructorProgram(instUserId, departmentId);
	}
	
	public int getDepartmentIdByCourseId(int id) {
		return courseDAO.selectDepartmentIdByCourseId(id);
	}
	
	public List<Integer> getInstructorIdListByDepartmentId(int departmentId){
		return courseDAO.selectInstructorIdListByDepartmentId(departmentId);
	}

	public int addTermCourse(int courseId, int userId, String term, int capacity, String room, int units,
			String status, int enrolled) {
		return courseDAO.insertTermCourse(courseId, userId, term, capacity, room, units, status, enrolled);
	}
}
