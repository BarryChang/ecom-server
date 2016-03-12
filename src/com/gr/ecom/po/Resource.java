package com.gr.ecom.po;

public class Resource {
	private int resourceId;
	private int typeId;
	private String resourcePath;
	private String resourceIndex;

	public Resource() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Resource(int resourceId, int typeId, String resourcePath,
			String resourceIndex) {
		super();
		this.resourceId = resourceId;
		this.typeId = typeId;
		this.resourcePath = resourcePath;
		this.resourceIndex = resourceIndex;
	}

	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getResourcePath() {
		return resourcePath;
	}

	public void setResourcePath(String resourcePath) {
		this.resourcePath = resourcePath;
	}

	public String getResourceIndex() {
		return resourceIndex;
	}

	public void setResourceIndex(String resourceIndex) {
		this.resourceIndex = resourceIndex;
	}

	@Override
	public String toString() {
		return "Resource [resourceId=" + resourceId + ", typeId=" + typeId
				+ ", resourcePath=" + resourcePath + ", resourceIndex="
				+ resourceIndex + "]";
	}

}
