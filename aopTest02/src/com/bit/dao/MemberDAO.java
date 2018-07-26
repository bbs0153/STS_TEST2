package com.bit.dao;

import java.util.ArrayList;

public class MemberDAO {
	
	public ArrayList<String> listAll(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("홍길동");
		list.add("강감찬");
		list.add("이순신");
		return list;
	}
	
	public void insertMember(String id, String pwd) {
		
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		int a = 4/0;
		System.out.println(id+"의 정보를 추가하였습니다");
	}
	
	
	public int deleteMember(String id) {
		System.out.println(id+"의 정보를 삭제하였습니다");
		return 1;
	}

}
