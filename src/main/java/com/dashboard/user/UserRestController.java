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
import com.dashboard.course.bo.CourseBO;
import com.dashboard.user.bo.UserBO;
import com.dashboard.user.model.User;

@RequestMapping("/user")
@RestController
public class UserRestController {
	
	@Autowired
	private UserBO userBO;
	
	@Autowired
	private CourseBO courseBO;
	
	@RequestMapping("/sign_in")
	public Map<String,Object> signIn(
			@RequestParam("computingId") String computingId,
			@RequestParam("password") String password,
			HttpServletRequest req,
			Model model){
		String encryptedPassword = EncryptUtils.md5(password);
		User user = userBO.getUserByComputingIdAndPassword(computingId,encryptedPassword);
		
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
			result.put("errorMessage", "Invalid credentials.");
		}
		
		return result;
	}
	
	@RequestMapping("/register_user")
	public Map<String,Object> registerUser(
			@RequestParam("computingId") String computingId,
			@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("userType") String userType,
			@RequestParam(value="departmentId", required=false) Integer departmentId,
			@RequestParam(value="programType", required=false) String programType,
			HttpServletRequest req,
			Model model){
		String encryptedPassword = EncryptUtils.md5("0000");	// The default pw of new user would be 0000. User should be told to change the pw later on.
		
		Map<String,Object> result = new HashMap<>();
		result.put("result_user", "success");
		
		if(userBO.addUser(computingId,encryptedPassword,name,email,userType,0,"/images/default_pfp/pfp.png") < 1) {
			result.put("result_user", "fail");
		}
		
		if(departmentId != null) {		// Insert program for this user
			int userId = userBO.getUserByComputingIdAndPassword(computingId, encryptedPassword).getId();
			if(userType.equals("Student") && programType != null) {
				if(courseBO.addStudentProgram((Integer)userId, (int)departmentId, programType) < 1) {
					result.put("result_program", "fail");
				} else {
					result.put("result_program", "success");
				}
			} else if(userType.equals("Instructor")) {
				if(courseBO.addInstructorProgram((Integer)userId, (int)departmentId) < 1) {
					result.put("result_program", "fail");
				} else {
					result.put("result_program", "success");
				}
			} else {
				result.put("result_program", "fail");
			}
		}
		
		return result;
	}
}
