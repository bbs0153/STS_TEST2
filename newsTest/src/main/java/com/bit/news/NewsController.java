package com.bit.news;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.dao.NewsDAO;
import com.bit.vo.NewsVO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class NewsController {
	@Autowired
	private NewsDAO dao;

	public void setDao(NewsDAO dao) {
		this.dao = dao;
	}

	@RequestMapping(value = "/listNews.do", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String listJson() {
		List<NewsVO> list = dao.listAll();
		String str = "";
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			str = mapper.writeValueAsString(list);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return str;
	}
	
	@RequestMapping(value = "/detailNews.do", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String getNews(int no) {
		NewsVO n = dao.getNew(no);
		String str = "";
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			str = mapper.writeValueAsString(n);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return str;
	}
}
