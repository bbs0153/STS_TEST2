package com.bit.book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.BookDAO;
import com.bit.vo.OrdersVO;

@Controller
public class BookController {

	@Autowired
	private BookDAO dao;

	public void setDao(BookDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/listBook.do")
	public ModelAndView list(String name) {
		Map map = new HashMap();
		map.put("name", name);
		List<OrdersVO> list = dao.list(map);
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		return mav;

	}

}
