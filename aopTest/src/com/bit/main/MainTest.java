package com.bit.main;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bit.dao.BoardDAO;
import com.bit.dao.MemberDAO;

public class MainTest {
	
	public static void main(String []args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/bit/main/beans.xml");
		MemberDAO mDao = (MemberDAO)context.getBean("mDao");
		BoardDAO bDao = (BoardDAO)context.getBean("bDao");
		
		mDao.deleteMember("tiger");
		bDao.insert();
		ArrayList<String> list = mDao.listAll();
		for(String name:list) {
			System.out.println(name);
		}
		//mDao.insertMember("tiger","tiger");
	}
}
