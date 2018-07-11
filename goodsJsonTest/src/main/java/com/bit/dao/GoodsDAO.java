package com.bit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bit.db.GoodsManager;
import com.bit.vo.GoodsVO;
import com.bit.vo.OrderInfo;

@Repository
public class GoodsDAO {

	public List<GoodsVO> listAll() {
		return GoodsManager.listAll();
	}

	public GoodsVO getGoods(int no) {
		return GoodsManager.getGoods(no);
	}
	
	public int insert(GoodsVO g) {
		return GoodsManager.insert(g);
	}
	
	public int insertOrder(OrderInfo info) {
		return GoodsManager.insertOrder(info);
	}

}
