package com.revature.beans;

public class Money {
	
	private String uName;
	private int amt;
	
	public Money() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Money(String uName, int amt) {
		super();
		this.uName = uName;
		this.amt = amt;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public int getAmt() {
		return amt;
	}

	public void setAmt(int amt) {
		this.amt = amt;
	}

	@Override
	public String toString() {
		return "Money [uName=" + uName + ", amt=" + amt + "]";
	}

}
