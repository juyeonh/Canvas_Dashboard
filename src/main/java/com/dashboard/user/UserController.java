package com.dashboard.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dashboard.course.bo.CourseBO;

@RequestMapping("/user")
@Controller
public class UserController {
	
	@Autowired
	private CourseBO courseBO;

	// http://localhost/user/login_view
	@RequestMapping("/login_view")
	public String loginView(Model model, HttpSession session) {
//		Object userId = session.getAttribute("userId");
//		model.addAttribute("userId", userId);
		
		model.addAttribute("viewName", "user/login");
		return "template/layout";
	}
	
	// localhost/user/sign_out
	@RequestMapping("/sign_out")
	public String signOut(HttpSession session) {
		session.removeAttribute("userId");
		session.removeAttribute("userComputingId");
		session.removeAttribute("userType");
		session.removeAttribute("profileImagePath");
		
		return "redirect:/user/login_view";
	}
	
	// http://localhost/user/add_user_view
	@RequestMapping("/add_user_view")
	public String addUserView(Model model, HttpSession session) {
		model.addAttribute("depList", courseBO.getDepartmentList());
		model.addAttribute("viewName", "admin/addUser");
		return "template/layout";
	}
	
}
