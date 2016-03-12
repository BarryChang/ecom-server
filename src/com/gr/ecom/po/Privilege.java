package com.gr.ecom.po;

public class Privilege {
	private int privilegeId;
	private String privilegeContent;

	public Privilege() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Privilege(int privilegeId, String privilegeContent) {
		super();
		this.privilegeId = privilegeId;
		this.privilegeContent = privilegeContent;
	}

	public int getPrivilegeId() {
		return privilegeId;
	}

	public void setPrivilegeId(int privilegeId) {
		this.privilegeId = privilegeId;
	}

	public String getPrivilegeContent() {
		return privilegeContent;
	}

	public void setPrivilegeContent(String privilegeContent) {
		this.privilegeContent = privilegeContent;
	}

	@Override
	public String toString() {
		return "Prililege [privilegeId=" + privilegeId + ", privilegeContent="
				+ privilegeContent + "]";
	}

}
