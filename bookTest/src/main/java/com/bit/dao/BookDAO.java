package com.bit.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bit.db.BookManager;
import com.bit.vo.OrdersVO;

@Repository
public class BookDAO {

	public List<OrdersVO> list(Map map) {
		return BookManager.list(map);
	}

}
