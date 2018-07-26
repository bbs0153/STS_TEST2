package com.bit.db;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bit.vo.GoodsVo;
import com.bit.vo.OrderDetail;
import com.bit.vo.OrderInfo;


public class MemberManager {
	private static SqlSessionFactory factory;
	static {
		try {
			String resource = "com/bit/db/mabatisConfig.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			factory =
			  new SqlSessionFactoryBuilder().build(inputStream);
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
	
	public static int isMember(Map map) {
		int re = -1;
		
		SqlSession session = factory.openSession();
		String db_pwd = session.selectOne("member.isMember",map);
		String user_pwd = (String) map.get("pwd");
		if (db_pwd == null) {
			re = -1;
		}
		else if (db_pwd.equals(user_pwd)) {
			re = 1;		//아이디가 존재하지 않음.			
		}else {
			re = 0;		//패스워드가 틀림
		}
		session.close();
		return re;		//올바른 회원
	}
	
		
}