package com.ddoc.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ddoc.login.model.LoginConfirmation;

public interface LoginConfirmationRepository extends JpaRepository<LoginConfirmation, Long>{

}
