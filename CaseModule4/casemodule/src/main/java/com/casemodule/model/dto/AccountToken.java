package com.casemodule.model.dto;

import com.casemodule.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountToken {
    private int id;
    private String username;
    private String password;
    private Role role;
    private String token;
}
