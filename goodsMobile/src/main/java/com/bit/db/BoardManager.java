package com.bit.db;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bit.vo.BoardVO;
import com.bit.vo.GoodsMobileVO;

public class BoardManager {
 
	
	
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

	
	public static List<BoardVO> listAll() {

		List<BoardVO> list = null;

		SqlSession session = factory.openSession();
		list = session.selectList("board.selectAll");
		session.close();
		return list;
	}

	public static BoardVO getBoard(int no) {
		BoardVO b = null;
		Map map = new HashMap();
		map.put("no", no);
		SqlSession session = factory.openSession();
		b = session.selectOne("board.getBoard", map);
		session.close();
		return b;
	}


}
