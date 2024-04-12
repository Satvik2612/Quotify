package com.booquo.Quotify.model;

import com.booquo.Quotify.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserView {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Role role;
}
