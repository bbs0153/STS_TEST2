package com.bit.goodsMobile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.dao.GoodsDAO;
import com.bit.vo.GoodsMobileVO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class BoardController {

	@Autowired
	private GoodsDAO dao;

	public void setDao(GoodsDAO dao) {
		this.dao = dao;
	}


	@RequestMapping(value = "/listBoard.do", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String listJson() {
		List<GoodsMobileVO> list = dao.listAll();
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

	@RequestMapping(value = "/detailGoods.do", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String getGoods(int no) {

		GoodsMobileVO g = dao.getGoods(no);
		String str = "";
		ObjectMapper mapper = new ObjectMapper();

		try {
			str = mapper.writeValueAsString(g);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return str;
	}
}
