package com.project.authshield_secure_authentication_server.Service;

import com.project.authshield_secure_authentication_server.Model.ChangePasswordRequest;
import com.project.authshield_secure_authentication_server.Model.ProfileUpdateRequest;
import com.project.authshield_secure_authentication_server.Repository.UserRespository;

public class UserServiceImpl implements UserService{

    private final UserRespository userRespository;

    public UserServiceImpl(UserRespository userRespository){
        this.userRespository=userRespository;
    }

    @Override
    public void updateProfile(final String hid, final ProfileUpdateRequest request) {
       //
    }

    @Override
    public void changePassword(final String hid, final ChangePasswordRequest request) {
       //
    }

    @Override
    public void deleteAccount(final String hid) {
       //
    }

    @Override
    public void reactivateAccount(final String hid) {
       //
    }
    
}
