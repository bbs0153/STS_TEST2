package com.bit.dao;

import java.util.ArrayList;

public class MemberDAO {
	
	public ArrayList<String> listAll(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("ȫ�浿");
		list.add("������");
		list.add("�̼���");
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
		System.out.println(id+"�� ������ �߰��Ͽ����ϴ�");
	}
	
	
	public int deleteMember(String id) {
		System.out.println(id+"�� ������ �����Ͽ����ϴ�");
		return 1;
	}

}
