package com.jdsolution.secureappstudy.model;

import com.jdsolution.secureappstudy.entity.AuthUsers;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class AuthUserPrincipal implements UserDetails {

    private AuthUsers authUsers;

    public AuthUserPrincipal(AuthUsers authUsers) {
        this.authUsers = authUsers;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return authUsers.getPassword();
    }

    @Override
    public String getUsername() {
        return authUsers.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; //UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; //UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; //UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
