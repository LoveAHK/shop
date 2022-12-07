package com.example.Shop.Models;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, ADMIN,KASSIR,ARENDODATEL,KKADOVSHIK;

    @Override
    public String getAuthority() {
        return name();
    }
}
