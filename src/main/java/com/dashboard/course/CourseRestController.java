package com.dashboard.course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dashboard.course.bo.CourseBO;
import com.dashboard.course.model.Department;

@RequestMapping("/course")
@RestController
public class CourseRestController {
	
	@Autowired
	private CourseBO courseBO;
	
	@RequestMapping("/add_department")
	public Map<String,Object> addDepartment(
			@RequestParam("department") String department,
			HttpServletRequest req,
			Model model){
		Map<String,Object> result = new HashMap<>();
		result.put("result", "success");
		
		if(courseBO.addDepartment(department) < 1) {
			result.put("result", "fail");
		}
		
		return result;
	}
	
	@RequestMapping("/add_course")
	public Map<String,Object> addCourse(
			@RequestParam("course") String course,
			@RequestParam("departmentId") int departmentId,
			HttpServletRequest req,
			Model model){
		Map<String,Object> result = new HashMap<>();
		result.put("result", "success");
		
		if(courseBO.checkDuplicateCourse(course)) {
			result.put("result", "duplicate");
			return result;
		}
		
		if(courseBO.addCourse(course, departmentId) < 1) {
			result.put("result", "fail");
		}
		
		return result;
	}
	
	@RequestMapping("/add_prerequisite")
	public Map<String,Object> addPrerequisite(
			@RequestParam("courseId") int courseId,
			@RequestParam("reqCourseId") int reqCourseId,
			HttpServletRequest req,
			Model model){
		Map<String,Object> result = new HashMap<>();
		result.put("result", "success");
		
		
		
		return result;
	}
	
}
