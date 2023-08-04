package com.casemodule.controller.user;

import com.casemodule.model.FriendRequest;
import com.casemodule.model.Friendship;
import com.casemodule.model.Post;
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
    @GetMapping("/friendRequests")
    public ResponseEntity<List<FriendRequest>> getAllFriendRequestByAccountId(@PathVariable int idAccount) {
        return new ResponseEntity<>(friendRequestService.getAllFriendRequestByAccountId(idAccount), HttpStatus.OK);
    }
    @GetMapping("/friendRequests/{idFriendRequest}/{action}")
    public ResponseEntity<FriendRequest> editFriendRequest(@PathVariable int idFriendRequest,
                                                                 @PathVariable int action) {
        FriendRequest friendRequest = friendRequestService.findById(idFriendRequest);
        if (action == 1) {
            Friendship friendship = new Friendship();
            friendship.setUser(friendRequest.getReceiver());
            friendship.setFriend(friendRequest.getSender());
            friendshipService.createFriendship(friendship);
            friendRequestService.deleteFriendRequest(idFriendRequest);
        } else {
            friendRequestService.deleteFriendRequest(idFriendRequest);
        }
        return new ResponseEntity<>(friendRequest, HttpStatus.OK);
    }

}
