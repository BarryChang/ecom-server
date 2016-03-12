package com.gr.ecom.po;

import java.util.Date;

public class User {

	private int userId;
	private String userName;
	private int userAge;
	private int userGender;
	private String userEmail;
	private String userPhone;
	private int communityId;
	private Date userRegisterDate;
	private int userScore;
	private int userLevel;
	private int privilegeId;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int userId, String userName, int userAge, int userGender,
			String userEmail, String userPhone, int communityId,
			Date userRegisterDate, int userScore, int userLevel, int privilegeId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userAge = userAge;
		this.userGender = userGender;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.communityId = communityId;
		this.userRegisterDate = userRegisterDate;
		this.userScore = userScore;
		this.userLevel = userLevel;
		this.privilegeId = privilegeId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public int getUserGender() {
		return userGender;
	}

	public void setUserGender(int userGender) {
		this.userGender = userGender;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public int getCommunityId() {
		return communityId;
	}

	public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}

	public Date getUserRegisterDate() {
		return userRegisterDate;
	}

	public void setUserRegisterDate(Date userRegisterDate) {
		this.userRegisterDate = userRegisterDate;
	}

	public int getUserScore() {
		return userScore;
	}

	public void setUserScore(int userScore) {
		this.userScore = userScore;
	}

	public int getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}

	public int getPrivilegeId() {
		return privilegeId;
	}

	public void setPrivilegeId(int privilegeId) {
		this.privilegeId = privilegeId;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", userAge=" + userAge + ", userGender=" + userGender
				+ ", userEmail=" + userEmail + ", userPhone=" + userPhone
				+ ", communityId=" + communityId + ", userRegisterDate="
				+ userRegisterDate + ", userScore=" + userScore
				+ ", userLevel=" + userLevel + ", privilegeId=" + privilegeId
				+ "]";
	}

}
