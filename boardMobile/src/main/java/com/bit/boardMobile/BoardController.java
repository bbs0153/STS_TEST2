package com.bit.boardMobile;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.dao.BoardDAO;
import com.bit.vo.BoardVO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class BoardController {
	
	@Autowired
	private BoardDAO dao;

	public void setDao(BoardDAO dao) {
		this.dao = dao;
	}

	@RequestMapping(value = "/listBoard.do", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String listJson() {
		List<BoardVO> list = dao.listAll();
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


}
