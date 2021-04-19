package com.ddoc.login.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.ddoc.login.enums.LoginConfirmationSituation;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data @Getter @Setter @NoArgsConstructor
public class LoginConfirmation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull private Long userId;
	@NotNull private String codeConfirmation;
	@NotNull private LoginConfirmationSituation loginConfirmationSituation;
	@NotNull private String sendDate;
	
	public LoginConfirmation(@NotNull Long userId, @NotNull String codeConfirmation, @NotNull LoginConfirmationSituation loginConfirmationSituation, @NotNull String sendDate) {
		this.userId = userId;
		this.codeConfirmation = codeConfirmation;
		this.loginConfirmationSituation = loginConfirmationSituation;
		this.sendDate = sendDate;
	}
}
