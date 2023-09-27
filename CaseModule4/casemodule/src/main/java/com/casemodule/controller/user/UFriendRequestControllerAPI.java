package com.casemodule.controller.user;

import com.casemodule.model.*;
import com.casemodule.service.IAccountService;
import com.casemodule.service.IFriendRequestService;
import com.casemodule.service.IFriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/user/{idAccount}")
public class UFriendRequestControllerAPI {
    @Autowired
    private IFriendRequestService friendRequestService;
    @Autowired
    private IFriendshipService friendshipService;
    @Autowired
    private IAccountService accountService;
    @GetMapping("/friendRequests")
    public ResponseEntity<List<FriendRequest>> getAllFriendRequestByAccountId(@PathVariable int idAccount) {
        return new ResponseEntity<>(friendRequestService.getAllFriendRequestByAccountId(idAccount), HttpStatus.OK);
    }
    @GetMapping("/friendRequests/{idFriendRequest}/{action}")
    public ResponseEntity<FriendRequest> editFriendRequest(@PathVariable int idFriendRequest,
                                                                 @PathVariable int action) {
        FriendRequest friendRequest = friendRequestService.findById(idFriendRequest);
        if (action == 1) {
            Friendship friendshipMe = new Friendship();
            friendshipMe.setUser(friendRequest.getReceiver());
            friendshipMe.setFriend(friendRequest.getSender());
            friendshipService.createFriendship(friendshipMe);   
            Friendship friendshipYou = new Friendship();
            friendshipYou.setUser(friendRequest.getSender());
            friendshipYou.setFriend(friendRequest.getReceiver());
            friendshipService.createFriendship(friendshipYou);
            friendRequestService.deleteFriendRequest(idFriendRequest);
        } else {
            friendRequestService.deleteFriendRequest(idFriendRequest);
        }
        return new ResponseEntity<>(friendRequest, HttpStatus.OK);
    }
    @GetMapping("/friendRequests/{idSender}")
    public ResponseEntity<FriendRequest> createFriendRequest(@PathVariable int idAccount, @PathVariable int idSender) {
        Account sender = accountService.findById(idSender);
        Account receiver = accountService.findById(idAccount);
        FriendRequest friendRequest = new FriendRequest();
        friendRequest.setReceiver(receiver);
        friendRequest.setSender(sender);
        friendRequestService.createFriendRequest(friendRequest);
        return new ResponseEntity<>(friendRequest, HttpStatus.OK);
    }

}
