package com.project.authshield_secure_authentication_server.Service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.authshield_secure_authentication_server.Config.UserPrincipal;
import com.project.authshield_secure_authentication_server.Entity.User;
import com.project.authshield_secure_authentication_server.Repository.UserRespository;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService{

private final UserRespository userRespository;

    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String email){
        User user = userRespository.findByEmail(email)
        .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
        return UserPrincipal.create(user);
    }
    
}
