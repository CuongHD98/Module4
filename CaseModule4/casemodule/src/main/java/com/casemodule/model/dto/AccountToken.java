package com.casemodule.model.dto;

import com.casemodule.model.Account;
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
    private Account account;
    private String token;
}
