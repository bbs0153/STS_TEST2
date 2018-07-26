package com.bit.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bit.dao.BoardDAO;
import com.bit.dao.MemberDAO;

public class MainTest {
	
	public static void main(String []args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/bit/main/beans02.xml");
		MemberDAO mDao = (MemberDAO)context.getBean("mDao");
		BoardDAO bDao = (BoardDAO)context.getBean("bDao");
		
		mDao.deleteMember("tiger");
		bDao.insert();
		//mDao.insertMember("tiger","tiger");
	}
}
