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
}
