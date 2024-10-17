package com.scm.scm20.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.scm20.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

    // extra methods db replated operations
    // custom query methods
    // custom finder methods
}