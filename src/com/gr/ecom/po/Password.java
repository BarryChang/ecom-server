package com.gr.ecom.po;

public class Password {
	private int passwordId;
	private String userName;
	private String password;
	private int typeId;

	public Password() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Password(int passwordId, String userName, String password, int typeId) {
		super();
		this.passwordId = passwordId;
		this.userName = userName;
		this.password = password;
		this.typeId = typeId;
	}

	public int getPasswordId() {
		return passwordId;
	}

	public void setPasswordId(int passwordId) {
		this.passwordId = passwordId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	@Override
	public String toString() {
		return "Password [passwordId=" + passwordId + ", userName=" + userName
				+ ", password=" + password + ", typeId=" + typeId + "]";
	}

}
