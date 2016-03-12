package com.gr.ecom.po;

public class Admin {

	private int adminId;
	private int adminLevel;
	private String password;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(int adminId, int adminLevel, String password) {
		super();
		this.adminId = adminId;
		this.adminLevel = adminLevel;
		this.password = password;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public int getAdminLevel() {
		return adminLevel;
	}

	public void setAdminLevel(int adminLevel) {
		this.adminLevel = adminLevel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminLevel=" + adminLevel
				+ ", password=" + password + "]";
	}

}
