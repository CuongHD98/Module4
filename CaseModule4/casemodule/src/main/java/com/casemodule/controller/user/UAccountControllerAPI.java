package com.casemodule.controller.user;

import com.casemodule.model.Account;
import com.casemodule.model.Friendship;
import com.casemodule.service.IAccountService;
import com.casemodule.service.IFriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/user/{idAccount}")
public class UAccountControllerAPI {
    @Autowired
    private IAccountService accountService;
    @Autowired
    private IFriendshipService friendshipService;
    @GetMapping()
    public ResponseEntity<Account> getAccountLogin(@PathVariable int idAccount) {
        return new ResponseEntity<>(accountService.findById(idAccount), HttpStatus.OK);
    }
    @GetMapping("/newFriends")
    public ResponseEntity<List<Account>> getAllNewAccount(@PathVariable int idAccount) {
        List<Friendship> friendships = friendshipService.getAllFriendshipByAccountId(idAccount);
        List<Account> accountList = accountService.getAll();
        List<Account> newFriends = new ArrayList<>();
        for (Account account : accountList) {
            if (account.getRole().getName().equals("ROLE_USER")) {
                if (account.getId() != idAccount) {
                    boolean checkFriend = false;
                    for (Friendship friendship : friendships) {
                        if (account.getId() == friendship.getFriend().getId()) {
                            checkFriend = true;
                            break;
                        }
                    }
                    if (!checkFriend) newFriends.add(account);
                }
            }

        }
        return new ResponseEntity<>(newFriends, HttpStatus.OK);
    }

}
