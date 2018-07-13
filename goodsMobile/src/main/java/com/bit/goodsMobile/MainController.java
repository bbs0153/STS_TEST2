package com.bit.goodsMobile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.GoodsDAO;

@Controller
public class MainController {
	
	@Autowired
	private GoodsDAO dao;

	public void setDao(GoodsDAO dao) {
		this.dao = dao;
	}
	
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
