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
import com.dashboard.course.model.CourseView;
import com.dashboard.course.model.Department;

@RequestMapping("/course")
@Controller
public class CourseController {
	
	@Autowired
	private CourseBO courseBO;

	// http://localhost/course/add_course_view
	@RequestMapping("/add_course_view")
	public String addDepartmentView(Model model, HttpSession session) {
		
		List<Department> depList = courseBO.getDepartmentList();
		
		List<CourseView> courseViewList = new ArrayList<>();
		for (int i = 0; i < depList.size(); i++) {
			CourseView cv = new CourseView();
			cv.setDep(depList.get(i));
			List<Course> courseList = courseBO.getCourseListByDepartmentId(depList.get(i).getId());
			cv.setCourseList(courseList);
			courseViewList.add(cv);
		}
		
		model.addAttribute("courseViewList",courseViewList);
		model.addAttribute("viewName", "course/addCourse");
		return "template/layout";
	}
	
}
