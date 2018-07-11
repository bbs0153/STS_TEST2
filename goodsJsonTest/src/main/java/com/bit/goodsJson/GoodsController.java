package com.bit.goodsJson;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.GoodsDAO;
import com.bit.vo.GoodsVO;
import com.bit.vo.OrderInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class GoodsController {

	@Autowired
	private GoodsDAO dao;

	public void setDao(GoodsDAO dao) {
		this.dao = dao;
	}

	@RequestMapping("/insertOrder.do")
	public ModelAndView insertOrder(OrderInfo info) {
		ModelAndView mav = new ModelAndView();
		int re = dao.insertOrder(info);
		String msg = "�ֹ�����";
		if (re != 1) {
			msg = "�ֹ�����";
		}
		mav.addObject("msg", msg);
		return mav;

	}

	@RequestMapping(value = "/listGoods.do", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String listJson() {
		List<GoodsVO> list = dao.listAll();
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

		GoodsVO g = dao.getGoods(no);
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
