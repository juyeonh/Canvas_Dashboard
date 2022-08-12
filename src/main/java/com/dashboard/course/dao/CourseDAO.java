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
	

	public int insertStudentProgram(
			@Param("stuUserId") Integer stuUserId, 
			@Param("departmentId") int departmentId, 
			@Param("type")String type);

	public int insertInstructorProgram(
			@Param("instUserId") Integer instUserId, 
			@Param("departmentId") int departmentId);

	public List<Integer> selectInstructorIdListByDepartmentId(int departmentId);
	
	public int insertTermCourse(
			@Param("courseId") int courseId, 
			@Param("userId") int userId, 
			@Param("term") String term, 
			@Param("capacity") int capacity, 
			@Param("room") String room, 
			@Param("units") int units,
			@Param("status") String status, 
			@Param("enrolled") int enrolled);
}
