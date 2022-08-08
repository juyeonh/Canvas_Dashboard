package com.dashboard.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Controller
public class UserController {

	// http://localhost/user/login_view
	@RequestMapping("/login_view")
	public String loginView(Model model, HttpSession session) {
//		Object userId = session.getAttribute("userId");
//		model.addAttribute("userId", userId);
		
		model.addAttribute("viewName", "user/login");
		return "template/layout";
	}
	
	// http://localhost/user/add_user_view
	@RequestMapping("/add_user_view")
	public String addUserView(Model model, HttpSession session) {
		model.addAttribute("viewName", "user/addUserView");
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
}
