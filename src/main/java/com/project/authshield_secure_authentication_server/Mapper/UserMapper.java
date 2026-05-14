package com.project.authshield_secure_authentication_server.Mapper;

import org.springframework.stereotype.Service;

import com.project.authshield_secure_authentication_server.Entity.User;
import com.project.authshield_secure_authentication_server.Model.ProfileUpdateRequest;
@Service
public class UserMapper {
    public void updateUserFromProfileUpdateRequest(final User savedUser, final ProfileUpdateRequest request){
        if(request.getEmail()!=null && !savedUser.getEmail().equals(request.getEmail())){
            // if input is not null and different from the current email, then update
            savedUser.setEmail(request.getEmail());
        }
         if(request.getPhoneNumber()!=null && !savedUser.getPhoneNumber().equals(request.getPhoneNumber())){
            savedUser.setPhoneNumber(request.getPhoneNumber());
        }
    }
}
