package com.ddoc.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ddoc.login.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
