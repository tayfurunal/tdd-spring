package com.tayfurunal.tddspring.user;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.beans.Transient;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class User implements UserDetails {

    private static final long serialVersionUID = 4074374728582967483L;

    @Id
    @GeneratedValue
    private long id;

    @NotNull(message = "Username cannot be null")
    @Size(min = 4, max = 255, message = "It must have min 4 and max 255 characters")
    @UniqueUsername
    private String username;

    @NotNull
    @Size(min = 4, max = 255)
    private String displayName;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, max = 255)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "Password must have at least one uppercase, one lowercase and one number")
    private String password;

    private String image;

    @Override
    @Transient
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList("Role_USER");
    }

    @Override
    @Transient
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @Transient
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @Transient
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @Transient
    public boolean isEnabled() {
        return true;
    }

}