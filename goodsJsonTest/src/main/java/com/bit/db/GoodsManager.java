package com.bit.db;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.sasl.SaslServerFactory;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bit.vo.GoodsVO;
import com.bit.vo.OrderDetailVO;
import com.bit.vo.OrderInfo;

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

	public static int insertOrder(OrderInfo info) {

		int re = -1;

		int cnt = 0;
		int okCnt = info.getItems().size() * 2 + 1;

		SqlSession session = factory.openSession();
		// 새로운 주문을 위한 주문번호
		// 주문상세에서 참조한다.
		int no = session.selectOne("goods.nextOrdersNo");

		HashMap orderMap = new HashMap();

		orderMap.put("no", no);
		orderMap.put("id", info.getId());
		orderMap.put("total", info.getTotal());
		orderMap.put("addr", info.getAddr());

		cnt = cnt + session.insert("goods.goods_orders_insert", orderMap);

		for (OrderDetailVO od : info.getItems()) {

			HashMap detail = new HashMap();

			detail.put("gno", od.getNo());
			detail.put("qty", od.getQty());
			detail.put("ono", no);

			cnt = cnt + session.insert("goods.orders_detail_insert", detail);
			cnt = cnt + session.update("goods.downQty", detail);

		}

		if (cnt == okCnt) {
			session.commit();
			re = 1;
		} else {
			session.rollback();
		}
		session.close();
		return re;

	}

	public static List<GoodsVO> listAll() {

		List<GoodsVO> list = null;

		SqlSession session = factory.openSession();
		list = session.selectList("goods.selectAll");
		session.close();
		return list;
	}

	public static GoodsVO getGoods(int no) {
		GoodsVO g = null;
		Map map = new HashMap();
		map.put("no", no);
		SqlSession session = factory.openSession();
		g = session.selectOne("goods.getGoods", map);
		session.close();
		return g;
	}

	public static int insert(GoodsVO g) {
		int re = -1;
		SqlSession session = factory.openSession(true);
		re = session.insert("goods.insert", g);
		session.close();
		return re;
	}

}
