package com.project.authshield_secure_authentication_server.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import com.project.authshield_secure_authentication_server.Model.ChangePasswordRequest;
import com.project.authshield_secure_authentication_server.Model.ProfileUpdateRequest;
import com.project.authshield_secure_authentication_server.Service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/user")
@RestController

public class UserController {

    private final UserService userService;

    // update user profile
    @PatchMapping("/{hid}/profile")
    public ResponseEntity<String> updateProfile(
            @PathVariable final String hid,
            @Valid @RequestBody final ProfileUpdateRequest request) {
        
        userService.updateProfile(hid, request);
        return ResponseEntity.ok("Profile updated successfully.");
    }

    // change user password
    @PostMapping("/{hid}/change-password")
    public ResponseEntity<String> changePassword(
            @PathVariable final String hid,
            @Valid @RequestBody final ChangePasswordRequest request) {
        
        userService.changePassword(hid, request);
        return ResponseEntity.ok("Password changed successfully.");
    }

    // deactivate user account
    @PutMapping("/{hid}/deactivate")
    public ResponseEntity<String> deactivateAccount(@PathVariable final String hid) {
        userService.deactivateAccount(hid);
        return ResponseEntity.ok("Account deactivated successfully.");
    }

	// reactivate user account
    @PutMapping("/{hid}/reactivate")
    public ResponseEntity<String> reactivateAccount(@PathVariable final String hid) {
        userService.reactivateAccount(hid);
        return ResponseEntity.ok("Account reactivated successfully.");
    }
}