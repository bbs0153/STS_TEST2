package com.bit.mobile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	
	@RequestMapping("insert.do")
	public void insert() {
		
	}
	
	@RequestMapping("/main.do")
	public ModelAndView main() {
		
		ModelAndView mav = new ModelAndView();
		
		return mav;
		
	}

}
