package com.bit.boardMobile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {
	

	
	@RequestMapping("/main.do")
	public ModelAndView MainList() {
		ModelAndView mav = new ModelAndView();
		
		return mav;
	}
	@RequestMapping("/board.do")
	public ModelAndView BoardList() {
		ModelAndView mav = new ModelAndView();
		
		return mav;
	}
	
}
