package com.project.authshield_secure_authentication_server.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.authshield_secure_authentication_server.Entity.User;

public interface UserRespository extends JpaRepository<Long, User>{
   Optional<User> findByEmail(String email);
   Optional<User> findByMobileNumber(String mobileNumber);
}
