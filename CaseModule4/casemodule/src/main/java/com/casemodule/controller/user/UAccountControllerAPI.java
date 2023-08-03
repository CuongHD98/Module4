package com.casemodule.controller.user;

import com.casemodule.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/user/{idAccount}")
public class UAccountControllerAPI {
    @Autowired
    private IAccountService accountService;

}
