package com.ironhack.otakuhub.security;

import com.ironhack.otakuhub.model.Userr;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public record SecurityUser(Userr userr) implements UserDetails{
    @Override
    public String getUsername() {
        return userr.getUsername();
    }

    @Override
    public String getPassword() {
        return userr.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return userr.getIsAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.stream(userr
                .getRoles()
                .split(","))
                .map(SimpleGrantedAuthority::new)
                .toList();
    }
}
