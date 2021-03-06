package com.bit.db;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bit.vo.GoodsMobileVO;

public class GoodsManager {
 
	
	
	public static SqlSessionFactory factory;

	static {

		try {

			Reader reader = Resources.getResourceAsReader("com/bit/db/mybatisConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

	
	public static List<GoodsMobileVO> listAll() {

		List<GoodsMobileVO> list = null;

		SqlSession session = factory.openSession();
		list = session.selectList("goods.selectAll");
		session.close();
		return list;
	}

	public static GoodsMobileVO getGoods(int no) {
		GoodsMobileVO g = null;
		Map map = new HashMap();
		map.put("no", no);
		SqlSession session = factory.openSession();
		g = session.selectOne("goods.getGoods", map);
		session.close();
		return g;
	}

	public static int insert(GoodsMobileVO g) {
		int re = -1;
		SqlSession session = factory.openSession(true);
		re = session.insert("goods.insert", g);
		session.close();
		return re;
	}

}
