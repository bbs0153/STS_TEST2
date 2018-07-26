package com.bit.mobileWeb;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.dao.MemberDao;

@Controller
public class LoginController {

	@Autowired
	private MemberDao dao;

	public void setDao(MemberDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("login.do")
	public void login(String id, String pwd, HttpSession session) {
		HashMap map = new HashMap();
		map.put("id", id);
		map.put("pwd", pwd);
		
		int re = dao.isMember(map);
		
		if (re ==1) {
			session.setAttribute("id", id);
			session.setAttribute("msg", "로그인 성공");
			System.out.println("로그인 성공");			
		}else if (re == 0) {
			session.setAttribute("msg", "패스워드가 틀림");
		}else if (re == -1) {
			session.setAttribute("msg", "아이디가 존재하지 않음");
		}
	}	
}
