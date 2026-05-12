package com.project.authshield_secure_authentication_server.Config;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.authshield_secure_authentication_server.Entity.User;

import lombok.Getter;

@Getter
public class UserPrincipal implements UserDetails {

    private final Long id;
    private final String hid;
    private final String email;

    @JsonIgnore
    private final String password;
    private final boolean isActive;
    private final boolean locked;
    private final boolean active;
    private final LocalDateTime accountExpiry;
    private final LocalDateTime passwordExpiry;
    private final Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(Long id, String hid, String email, String password, boolean isActive, boolean locked,
            boolean active, LocalDateTime accountExpiry, LocalDateTime passwordExpiry,
            Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.hid = hid;
        this.email = email;
        this.password = password;
        this.isActive = isActive;
        this.locked = locked;
        this.active = active;
        this.accountExpiry = accountExpiry;
        this.passwordExpiry = passwordExpiry;
        this.authorities = authorities;
    }

    public static UserDetails create(User user) {
        var authorities = user.getRole().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.name()))
                .collect(Collectors.toList());
        return new UserPrincipal(user.getId(), user.getHid(), user.getEmail(),
                user.getPassword(), user.isActive(), user.isLocked(),
                user.isActive(), LocalDateTime.now(), LocalDateTime.now(), authorities);
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountExpiry.isAfter(LocalDateTime.now());
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return passwordExpiry.isAfter(LocalDateTime.now());
    }
}
