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
}
