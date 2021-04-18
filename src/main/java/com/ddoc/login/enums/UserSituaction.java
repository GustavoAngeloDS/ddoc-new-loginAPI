package com.ddoc.login.enums;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/*********************************************************************
 * About this routine: Enum of User situaction                       * 
 *********************************************************************
 * Developer:                                                        *
 * Feature description:                                              *
 * Date:                                                             *
 * ***************************************************************** *
 * Developer: Gustavo Angelo da Silva                                *
 * Feature description: First version                                *
 * Date: 17/04/2021                                                  *
 *********************************************************************/

public enum UserSituaction {
	ACTIVE(0), WAITING_EMAIL_VALIDATION(1), DISABLED(2);
	
	private Integer userSituaction;
	
	UserSituaction(int userSituaction){
		this.userSituaction = userSituaction;
	}
	
	public Integer getUserSituaction() {
		return this.userSituaction;
	}
	
	public void setUserSituaction(Integer userSituaction) {
		this.userSituaction = userSituaction;
	}
}
