package com.gr.ecom.po;

public class Type {
	private int typeId;
	private String type;

	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Type(int typeId, String type) {
		super();
		this.typeId = typeId;
		this.type = type;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Type [typeId=" + typeId + ", type=" + type + "]";
	}

}
