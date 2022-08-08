package com.dashboard.course.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dashboard.course.model.Course;
import com.dashboard.course.model.Department;

@Repository
public interface CourseDAO {
	
	public int insertDepartment(String name);
	
	public int insertCourse(
			@Param("name") String name,
			@Param("departmentId") int departmentId);
	
	public int insertPrerequisite(
			@Param("courseId") int courseId,
			@Param("reqCourseId") int reqCourseId);
	
	public List<Department> selectDepartmentList();
	
	public boolean checkDuplicateCourse(String name);

	public List<Course> selectCourseListByDepartmentId(int departmentId);
}
