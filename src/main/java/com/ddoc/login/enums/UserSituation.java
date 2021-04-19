package com.ddoc.login.enums;

public enum UserSituation {
	ACTIVE(0), WAITING_EMAIL_VALIDATION(1), DISABLED(2);
	
	private Integer userSituation;
	
	UserSituation(int userSituation){
		this.userSituation = userSituation;
	}
	
	public Integer getUserSituation() {
		return this.userSituation;
	}
	
	public void setUserSituation(Integer userSituation) {
		this.userSituation = userSituation;
	}
}
