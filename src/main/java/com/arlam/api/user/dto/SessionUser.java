package com.arlam.api.user.dto;

import com.arlam.api.user.domain.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {

    private String email;

    public SessionUser(User user){
        this.email = user.getEmail();
    }
}
