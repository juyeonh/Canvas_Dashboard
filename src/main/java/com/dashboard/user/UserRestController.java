package com.dashboard.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dashboard.common.EncryptUtils;
import com.dashboard.user.bo.UserBO;
import com.dashboard.user.model.User;

@RequestMapping("/user")
@RestController
public class UserRestController {
	
	@Autowired
	private UserBO userBO;
	
	@RequestMapping("/sign_in")
	public Map<String,Object> signIn(
			@RequestParam("computingId") String computingId,
			@RequestParam("password") String password,
			HttpServletRequest req,
			Model model){
		String encryptedPassword = EncryptUtils.md5(password);
		User user = userBO.getUserByComputingId(computingId,encryptedPassword);
		
		Map<String,Object> result = new HashMap<>();
		if(user != null) {
			// session - 로그인이 성공하면 로그인 상태 유지를 위해 세션에 사용자에 대한 필요한 정보를 담는다.
			HttpSession session = req.getSession();
			session.setAttribute("userId", user.getId());
			session.setAttribute("userComputingId", user.getComputingId());
			session.setAttribute("userName", user.getName());
			
			session.setAttribute("profileImagePath", user.getProfileImagePath());
			
			result.put("result", "success");
		} else {
			// 실패하면 실패 응답
			result.put("errorMessage", "존재하지 않는 사용자입니다.");
		}
		
		return result;
	}
}
