package com.ddoc.login.enums;

public enum LoginConfirmationSituation {
	CREATED(0), SENDED(1), ACCEPTED(2);
	
	private Integer loginConfirmationSituation;
	
	LoginConfirmationSituation(int loginConfirmationSituation){
		this.loginConfirmationSituation = loginConfirmationSituation;
	}
	
	public Integer getLoginConfirmationSituation() {
		return this.loginConfirmationSituation;
	}
	
	public void setLoginConfirmationSituation(Integer loginConfirmationSituation) {
		this.loginConfirmationSituation = loginConfirmationSituation;
	}
}
