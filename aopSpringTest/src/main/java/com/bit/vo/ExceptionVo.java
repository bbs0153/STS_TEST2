package com.bit.vo;

public class ExceptionVo {
	
	private int no;
	private String svname;
	private String extype;
	private String reqtime;
	public ExceptionVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExceptionVo(int no, String svname, String extype, String reqtime) {
		super();
		this.no = no;
		this.svname = svname;
		this.extype = extype;
		this.reqtime = reqtime;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getSvname() {
		return svname;
	}
	public void setSvname(String svname) {
		this.svname = svname;
	}
	public String getExtype() {
		return extype;
	}
	public void setExtype(String extype) {
		this.extype = extype;
	}
	public String getReqtime() {
		return reqtime;
	}
	public void setReqtime(String reqtime) {
		this.reqtime = reqtime;
	}
	
	

}
