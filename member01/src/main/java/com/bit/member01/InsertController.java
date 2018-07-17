package com.bit.member01;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.dao.MemberDAO;
import com.bit.vo.MemberVO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class InsertController {
	
	@Autowired
	private MemberDAO dao;

	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}
	
	
	@RequestMapping(value = "/insertMember.do", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String insertJson(MemberVO m) {
		int re = dao.insert(m);
		String str = "성공";
		if(re<0) {
			str="실패";
		}
		return str;
	}
}
