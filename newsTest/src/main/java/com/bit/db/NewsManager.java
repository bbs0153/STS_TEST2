package com.bit.db;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bit.vo.NewsVO;

public class NewsManager {

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

	public static List<NewsVO> listAll() {
		List<NewsVO> list = null;

		SqlSession session = factory.openSession();
		list = session.selectList("news.selectAll");
		session.close();
		return list;
	}

	public static NewsVO getNews(int no) {
		Map map = new HashMap();
		map.put("no", no);
		NewsVO n = null;
		SqlSession session = factory.openSession();
		n = session.selectOne("news.detail", map);
		session.close();
		return n;
	}

}
