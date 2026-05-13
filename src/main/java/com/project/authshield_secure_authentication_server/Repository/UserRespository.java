package com.project.authshield_secure_authentication_server.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.authshield_secure_authentication_server.Entity.User;

@Repository
public interface UserRespository extends JpaRepository<User, Long>{
   Optional<User> findByEmailIgnoreCase(String email);
   Optional<User> findByMobileNumber(String mobileNumber);
   Optional<User> findByHid(String hid);
}
