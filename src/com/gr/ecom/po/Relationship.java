package com.gr.ecom.po;

public class Relationship {
	private int relationshipId;
	private int userId;
	private int targetId;
	private int typeId;

	public Relationship() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Relationship(int relationshipId, int userId, int targetId, int typeId) {
		super();
		this.relationshipId = relationshipId;
		this.userId = userId;
		this.targetId = targetId;
		this.typeId = typeId;
	}

	public int getRelationshipId() {
		return relationshipId;
	}

	public void setRelationshipId(int relationshipId) {
		this.relationshipId = relationshipId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTargetId() {
		return targetId;
	}

	public void setTargetId(int targetId) {
		this.targetId = targetId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	@Override
	public String toString() {
		return "Relationship [relationshipId=" + relationshipId + ", userId="
				+ userId + ", targetId=" + targetId + ", typeId=" + typeId
				+ "]";
	}

}
