package com.letsfly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.letsfly.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{

    @Query("SELECT CASE WHEN COUNT(*) > 0 THEN TRUE ELSE FALSE END FROM User u WHERE u.username = :username") // Indovina chi ha scritto questa query
        boolean checkIfUsernameExist(@Param("username") String username);
    @Query("SELECT u FROM User u WHERE u.username = :username AND u.password = :password")
        User authorizeUser(@Param("username") String username,@Param("password") String password);
}
