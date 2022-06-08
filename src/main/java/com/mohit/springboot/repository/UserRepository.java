package com.mohit.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mohit.springboot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
