package com.casemodule.controller.user;

import com.casemodule.model.Friendship;
import com.casemodule.service.IFriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/user/{idAccount}")
public class UFriendshipControllerAPI {
    @Autowired
    private IFriendshipService friendshipService;
    @GetMapping("/friendships")
    public ResponseEntity<List<Friendship>> getAllFriendshipByAccountId(@PathVariable int idAccount) {
        return new ResponseEntity<>(friendshipService.getAllFriendshipByAccountId(idAccount), HttpStatus.OK);
    }
    @GetMapping("/friendships/{idFriendship}")
    public ResponseEntity<Friendship> deleteFriendship(@PathVariable int idFriendship) {
        Friendship friendship = friendshipService.findById(idFriendship);
        friendshipService.deleteFriendship(idFriendship);
        return new ResponseEntity<>(friendship, HttpStatus.OK);
    }

}
