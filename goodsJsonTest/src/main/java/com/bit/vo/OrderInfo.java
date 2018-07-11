package com.bit.vo;

import java.util.List;

public class OrderInfo {

	private String id;
	private int total;
	private String addr;
	private List<OrderDetailVO> items;

	public OrderInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderInfo(String id, int total, String addr, List<OrderDetailVO> items) {
		super();
		this.id = id;
		this.total = total;
		this.addr = addr;
		this.items = items;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public List<OrderDetailVO> getItems() {
		return items;
	}

	public void setItems(List<OrderDetailVO> items) {
		this.items = items;
	}

}
