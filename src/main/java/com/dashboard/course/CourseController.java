package com.dashboard.course;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dashboard.course.bo.CourseBO;
import com.dashboard.course.model.Course;
import com.dashboard.course.model.Department;

@RequestMapping("/course")
@Controller
public class CourseController {
	
	@Autowired
	private CourseBO courseBO;

	// http://localhost/course/add_course_view
	@RequestMapping("/add_course_view")
	public String addDepartmentView(Model model, HttpSession session) {
		
		List<Department> departmentList = courseBO.getDepartmentList();
		model.addAttribute("departmentList", departmentList);
		
		for (Department dep : departmentList) {
			List<Course> courseList = courseBO.getCourseListByDepartmentId(dep.getId());
			model.addAttribute("courseList" + dep.getId(), courseList);
		}
		
		model.addAttribute("viewName", "course/add_course");
		return "template/layout";
	}
	
}
