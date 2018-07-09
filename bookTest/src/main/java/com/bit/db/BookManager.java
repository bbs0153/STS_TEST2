package com.bit.db;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bit.vo.OrdersVO;

public class BookManager {

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

	public static List<OrdersVO> list(Map map) {

		List<OrdersVO> list = null;
		SqlSession session = factory.openSession();
		session.selectList("orders.list", map);
		session.close();
		return list;

	}

}
