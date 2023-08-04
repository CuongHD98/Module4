package com.casemodule.controller.user;

import com.casemodule.model.Follow;
import com.casemodule.service.IFollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/user/{idAccount}")
public class UFollowControllerAPI {
    @Autowired
    private IFollowService followService;
    @GetMapping("/follows")
    public ResponseEntity<Follow> getFollowByAccountId(@PathVariable int idAccount) {
        return new ResponseEntity<>(followService.getFollowByAccountId(idAccount), HttpStatus.OK);
    }

}
