package com.gr.ecom.po;

public class Community {
	private int communityId;
	private String communityName;
	private int communityLevel;
	private int communityCapacity;
	private String communityBackground;
	private String communitySignature;
	private int communityNoteNumber;
	private int communityThemeNumber;

	public Community() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Community(int communityId, String communityName,
			int communityLevel, int communityCapacity,
			String communityBackground, String communitySignature,
			int communityNoteNumber, int communityThemeNumber) {
		super();
		this.communityId = communityId;
		this.communityName = communityName;
		this.communityLevel = communityLevel;
		this.communityCapacity = communityCapacity;
		this.communityBackground = communityBackground;
		this.communitySignature = communitySignature;
		this.communityNoteNumber = communityNoteNumber;
		this.communityThemeNumber = communityThemeNumber;
	}

	public int getCommunityId() {
		return communityId;
	}

	public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}

	public String getCommunityName() {
		return communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}

	public int getCommunityLevel() {
		return communityLevel;
	}

	public void setCommunityLevel(int communityLevel) {
		this.communityLevel = communityLevel;
	}

	public int getCommunityCapacity() {
		return communityCapacity;
	}

	public void setCommunityCapacity(int communityCapacity) {
		this.communityCapacity = communityCapacity;
	}

	public String getCommunityBackground() {
		return communityBackground;
	}

	public void setCommunityBackground(String communityBackground) {
		this.communityBackground = communityBackground;
	}

	public String getCommunitySignature() {
		return communitySignature;
	}

	public void setCommunitySignature(String communitySignature) {
		this.communitySignature = communitySignature;
	}

	public int getCommunityNoteNumber() {
		return communityNoteNumber;
	}

	public void setCommunityNoteNumber(int communityNoteNumber) {
		this.communityNoteNumber = communityNoteNumber;
	}

	public int getCommunityThemeNumber() {
		return communityThemeNumber;
	}

	public void setCommunityThemeNumber(int communityThemeNumber) {
		this.communityThemeNumber = communityThemeNumber;
	}

	@Override
	public String toString() {
		return "Community [communityId=" + communityId + ", communityName="
				+ communityName + ", communityLevel=" + communityLevel
				+ ", communityCapacity=" + communityCapacity
				+ ", communityBackground=" + communityBackground
				+ ", communitySignature=" + communitySignature
				+ ", communityNoteNumber=" + communityNoteNumber
				+ ", communityThemeNumber=" + communityThemeNumber + "]";
	}

}
