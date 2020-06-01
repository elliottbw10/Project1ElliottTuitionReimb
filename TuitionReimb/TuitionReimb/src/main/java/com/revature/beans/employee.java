package com.revature.beans;

public class employee {
	
	private String uName;
	private String pass;
	private String fName;
	private String lName;
	private int amt;
	
	public employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public employee(String uName, String pass, String fName, String lName, int amt) {
		super();
		this.uName = uName;
		this.pass = pass;
		this.fName = fName;
		this.lName = lName;
		this.amt = amt;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public int getAmt() {
		return amt;
	}

	public void setAmt(int amt) {
		this.amt = amt;
	}

	@Override
	public String toString() {
		return "employee [uName=" + uName + ", pass=" + pass + ", fName=" + fName + ", lName=" + lName + ", amt=" + amt
				+ "]";
	}
	
}