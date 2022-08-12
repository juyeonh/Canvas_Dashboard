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
import com.dashboard.course.model.DepartmentView;
import com.dashboard.user.bo.UserBO;
import com.dashboard.user.model.User;

@RequestMapping("/course")
@Controller
public class CourseController {
	
	@Autowired
	private UserBO userBO;
	
	@Autowired
	private CourseBO courseBO;

	// http://localhost/course/add_course_view
	@RequestMapping("/add_course_view")
	public String addCourseView(Model model, HttpSession session) {
		List<Department> depList = courseBO.getDepartmentList();
		
		List<DepartmentView> depViewList = new ArrayList<>();
		for (int i = 0; i < depList.size(); i++) {
			DepartmentView dv = new DepartmentView();
			dv.setDep(depList.get(i));
			List<Course> courseList = courseBO.getCourseListByDepartmentId(depList.get(i).getId());
			dv.setCourseList(courseList);
			depViewList.add(dv);
		}
		
		model.addAttribute("depViewList",depViewList);
		model.addAttribute("viewName", "admin/addCourse");
		return "template/layout";
	}
	
	// http://localhost/course/add_course_view
	@RequestMapping("/add_term_course_view")
	public String addTermCourseView(Model model, HttpSession session) {
		List<Department> depList = courseBO.getDepartmentList();
		
		List<DepartmentView> depViewList = new ArrayList<>();
		for (int i = 0; i < depList.size(); i++) {
			DepartmentView dv = new DepartmentView();
			dv.setDep(depList.get(i));
			List<Course> courseList = courseBO.getCourseListByDepartmentId(depList.get(i).getId());
			dv.setCourseList(courseList);
			List<User> instructorList = userBO.getInstructorListByDepartmentId(depList.get(i).getId());
			dv.setInstructorList(instructorList);
			depViewList.add(dv);
		}
		
		model.addAttribute("depViewList",depViewList);
		model.addAttribute("viewName", "admin/addTermCourse");
		return "template/layout";
	}
	
}
