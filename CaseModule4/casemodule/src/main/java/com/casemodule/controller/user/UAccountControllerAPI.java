package com.casemodule.controller.user;

import com.casemodule.model.Account;
import com.casemodule.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/user/{idAccount}")
public class UAccountControllerAPI {
    @Autowired
    private IAccountService accountService;
    @GetMapping()
    public ResponseEntity<Account> getAccountLogin(@PathVariable int idAccount) {
        return new ResponseEntity<>(accountService.findById(idAccount), HttpStatus.OK);
    }

}
