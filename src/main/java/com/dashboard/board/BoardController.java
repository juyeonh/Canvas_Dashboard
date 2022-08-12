package com.dashboard.board;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/board")
@Controller
public class BoardController {

	
	// http://localhost/board/board_view
	@RequestMapping("/board_view")
	public String boardView(Model model, HttpSession session) {
		model.addAttribute("viewName", "board/board");
		
		Object userType = session.getAttribute("userType");
		if(userType != null) {
			if(userType.equals("Administrator")) {
				model.addAttribute("viewName", "admin/addUser");
			}
		}
		
//		List<CardView> cardList = boardBO.generateCardList((Integer) userId);
//		model.addAttribute("cardList", cardList);
		
		return "template/layout";
	}
	
}
