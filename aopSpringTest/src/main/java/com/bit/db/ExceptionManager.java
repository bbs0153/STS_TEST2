package com.bit.db;

import java.io.Reader;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class ExceptionManager {
	
	private static SqlSessionFactory factory;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("com\\bit\\db\\mybatisConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static int insert(Map map)
	{
		int re = -1;
		
		SqlSession session = factory.openSession();
		re = session.insert("exception.insert", map);
		session.commit();
		session.close();
		
		return re;
		
	}

}
