package com.ddoc.login.model;

import java.io.Serializable;

/*********************************************************************
 * About this routine: Entity of User model                          * 
 *********************************************************************
 * Developer:                                                        *
 * Feature description:                                              *
 * Date:                                                             *
 * ***************************************************************** *
 * Developer: Gustavo Angelo da Silva                                *
 * Feature description: First version                                *
 * Date: 17/04/2021                                                  *
 *********************************************************************/

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.ddoc.login.enums.UserSituation;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data @Getter @Setter @NoArgsConstructor
@Table(name="USERS")
public class User implements Serializable {

	private static final long serialVersionUID = 4736739593599755328L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull private String firstName;
	@NotNull private String lastName;
	@NotNull private String email;
	@NotNull private String password;
	@NotNull private UserSituation userSituation;
	@NotNull private String registrationDate;
	
	public User(@NotNull String firstName, @NotNull String lastName, @NotNull String email, @NotNull String password, @NotNull UserSituation userSituation, @NotNull String registrationDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.userSituation = userSituation;
		this.registrationDate = registrationDate;
	}
}
