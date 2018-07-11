package com.bit.vo;

public class OrderDetailVO {

	private int no;
	private int qty;

	public OrderDetailVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetailVO(int no, int qty ){
		super();
		this.no = no;
		this.qty = qty;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}


	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

}
