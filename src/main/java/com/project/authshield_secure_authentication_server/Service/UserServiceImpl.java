package com.project.authshield_secure_authentication_server.Service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.authshield_secure_authentication_server.Entity.User;
import com.project.authshield_secure_authentication_server.Mapper.UserMapper;
import com.project.authshield_secure_authentication_server.Model.ChangePasswordRequest;
import com.project.authshield_secure_authentication_server.Model.ProfileUpdateRequest;
import com.project.authshield_secure_authentication_server.Repository.UserRespository;

@Service
public class UserServiceImpl implements UserService {
   private final UserMapper userMapper;
   private final UserRespository userRespository;
   private final PasswordEncoder passwordEncoder;

   public UserServiceImpl(UserMapper userMapper, UserRespository userRespository, PasswordEncoder passwordEncoder) {
      this.userMapper = userMapper;
      this.userRespository = userRespository;
      this.passwordEncoder = passwordEncoder;
   }

   @Override
   public void updateProfile(final String hid, final ProfileUpdateRequest request) {
      //
      final User savedUser = userRespository.findByHid(hid).orElseThrow();
      userMapper.updateUserFromProfileUpdateRequest(savedUser, request);
      if(savedUser.getEmail()==null || savedUser.getPhoneNumber()==null){
         throw new IllegalArgumentException("Email and phone number cannot be null");
      }
      userRespository.save(savedUser);
   }

   @Override
   public void changePassword(final String hid, final ChangePasswordRequest request) {
      //
      if(!request.getNewPassword().equals(request.getConfirmNewPassword())){
         throw new IllegalArgumentException("New password and confirm new password do not match");
      }
      final User savedUser = userRespository.findByHid(hid).orElseThrow();
      if(!passwordEncoder.matches(request.getNewPassword(), savedUser.getPassword())){
         throw new IllegalArgumentException("Choose another password");
      }
      savedUser.setPassword(passwordEncoder.encode(request.getNewPassword()));
      userRespository.save(savedUser);
   }

   @Override
   public void deactivateAccount(final String hid) {
      //
      final User savedUser = userRespository.findByHid(hid).orElseThrow();
      if(!savedUser.isActive()){
         throw new IllegalStateException("Account is already deactivated");
      }
      savedUser.setActive(false);
      userRespository.save(savedUser);
   }

   @Override
   public void reactivateAccount(final String hid) {
      //
      final User savedUser = userRespository.findByHid(hid).orElseThrow();
      if(savedUser.isActive()){
         throw new IllegalStateException("Account is already activated");
      }
      savedUser.setActive(true);
      userRespository.save(savedUser);
   }
}