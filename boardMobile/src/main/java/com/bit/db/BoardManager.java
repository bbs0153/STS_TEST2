package com.bit.db;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bit.vo.BoardVO;

public class BoardManager {

	private static SqlSessionFactory factory;

	static {

		try {

			Reader reader = Resources.getResourceAsReader("com/bit/db/mybatisConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);

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

}
