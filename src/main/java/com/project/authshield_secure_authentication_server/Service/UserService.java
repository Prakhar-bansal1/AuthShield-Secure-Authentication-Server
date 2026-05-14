package com.project.authshield_secure_authentication_server.Service;

import com.project.authshield_secure_authentication_server.Model.ChangePasswordRequest;
import com.project.authshield_secure_authentication_server.Model.ProfileUpdateRequest;

public interface UserService {

     public void updateProfile(String hid, ProfileUpdateRequest request);

    public void changePassword(String hid, ChangePasswordRequest request);

    public void deactivateAccount(String hid);

    public void reactivateAccount(String hid);
}
