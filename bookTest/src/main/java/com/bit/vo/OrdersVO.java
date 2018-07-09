package com.bit.vo;

public class OrdersVO {

	private String bookname;
	private String publisher;
	private int price;
	private int saleprice;
	private String orderdate;
	private String address;
	private String phone;

	public OrdersVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrdersVO(String bookname, String publisher, int price, int saleprice, String orderdate, String address,
			String phone) {
		super();
		this.bookname = bookname;
		this.publisher = publisher;
		this.price = price;
		this.saleprice = saleprice;
		this.orderdate = orderdate;
		this.address = address;
		this.phone = phone;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSaleprice() {
		return saleprice;
	}

	public void setSaleprice(int saleprice) {
		this.saleprice = saleprice;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
