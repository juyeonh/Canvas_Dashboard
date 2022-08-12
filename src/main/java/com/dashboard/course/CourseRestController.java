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
import com.dashboard.user.bo.UserBO;
import com.dashboard.user.model.User;

@RequestMapping("/course")
@RestController
public class CourseRestController {
	
	@Autowired
	private CourseBO courseBO;
	
	@Autowired
	private UserBO userBO;
	
	@RequestMapping("/add_department")
	public Map<String,Object> addDepartment(
			@RequestParam("department") String department){
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
			HttpServletRequest req){
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
			@RequestParam("reqCourseId") int reqCourseId){
		Map<String,Object> result = new HashMap<>();
		result.put("result", "success");
		
		if(courseBO.addPrerequisite(courseId, reqCourseId) < 1) {
			result.put("result", "fail");
		}
		return result;
	}
	
	@RequestMapping("/add_program")
	public Map<String,Object> addProgram(
			@RequestParam("computingId") String computingId,
			@RequestParam("departmentId") int departmentId,
			@RequestParam(value="programType", required=false) String programType){
		Map<String,Object> result = new HashMap<>();
		result.put("result", "success");
		
		User user = userBO.getUserByComputingId(computingId);
		if(user.getType().equals("Student")) {
			if(programType != null) {
				courseBO.addStudentProgram((Integer)user.getId(), departmentId, programType);
			} else {
				result.put("result", "fail");
			}
		} else if(user.getType().equals("Instructor")){
			courseBO.addInstructorProgram((Integer)user.getId(), departmentId);
		} else {
			result.put("result", "fail");
		}
		return result;
	}
	
	@RequestMapping("/add_term_course")
	public Map<String,Object> addTermCourse(
			@RequestParam("courseId") int courseId,
			@RequestParam("instructorId") int instructorId,
			@RequestParam("term") String term,
			@RequestParam("capacity") int capacity,
			@RequestParam("room") String room,
			@RequestParam("units") int units,
			@RequestParam("status") String status){
		Map<String,Object> result = new HashMap<>();
		result.put("result", "success");
		
		if(courseBO.addTermCourse(courseId,instructorId,term,capacity,room,units,status,0) < 1) {
			result.put("result", "fail");
		}
		
		return result;
	}
	
	@RequestMapping("/get_instructors")
	public Map<String,Object> getInstructors(
			@RequestParam("courseId") int courseId){
		Map<String,Object> result = new HashMap<>();
		result.put("result", "success");
		
		int depId = courseBO.getDepartmentIdByCourseId(courseId);
		List<User> instructorList = userBO.getInstructorListByDepartmentId(depId);
		result.put("data", instructorList);
		
		return result;
	}
	
}
