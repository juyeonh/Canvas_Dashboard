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
//		Object userId = session.getAttribute("userId");
//		model.addAttribute("userId", userId);
//		
//		List<CardView> cardList = timelineBO.generateCardList((Integer) userId);	// CardView = Post + Comment + User + Like
//		model.addAttribute("cardList", cardList);
		
		model.addAttribute("viewName", "board/board");
		return "template/layout";
	}
	
}
