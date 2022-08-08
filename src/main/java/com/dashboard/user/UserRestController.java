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
			HttpSession session = req.getSession();
			session.setAttribute("userId", user.getId());
			session.setAttribute("userComputingId", user.getComputingId());
			session.setAttribute("userType", user.getType());
			session.setAttribute("profileImagePath", user.getProfileImagePath());
			
			if(user.getStatus() == 0) {	// admin에서 만들어진 후 한 번도 인증되지 않은 계정이면 등록
				userBO.updateUserStatusById(user.getId());
			}
			
			result.put("result", "success");
		} else {
			result.put("errorMessage", "존재하지 않는 사용자입니다.");
		}
		
		return result;
	}
	
	@RequestMapping("/register_user")
	public Map<String,Object> registerUser(
			@RequestParam("computingId") String computingId,
			@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("type") String type,
			HttpServletRequest req,
			Model model){
		String encryptedPassword = EncryptUtils.md5("0000");	// The default pw of new user would be 0000. User should be told to change the pw later on.
		userBO.addUser(computingId,encryptedPassword,name,email,type,0);
		
		Map<String,Object> result = new HashMap<>();
		result.put("result", "success");
		
		return result;
	}
}
