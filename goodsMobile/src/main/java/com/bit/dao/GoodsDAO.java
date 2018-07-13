package com.bit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bit.db.GoodsManager;
import com.bit.vo.GoodsMobileVO;

@Repository
public class GoodsDAO {

	public List<GoodsMobileVO> listAll() {
		return GoodsManager.listAll();
	}

	public GoodsMobileVO getGoods(int no) {
		return GoodsManager.getGoods(no);
	}
	
	public int insert(GoodsMobileVO g) {
		return GoodsManager.insert(g);
	}
	

}
