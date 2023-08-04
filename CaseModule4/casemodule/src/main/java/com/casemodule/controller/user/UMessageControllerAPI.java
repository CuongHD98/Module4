package com.casemodule.controller.user;

import com.casemodule.model.Account;
import com.casemodule.model.Friendship;
import com.casemodule.model.Message;
import com.casemodule.model.dto.AllFriendMessage;
import com.casemodule.service.IAccountService;
import com.casemodule.service.IFriendshipService;
import com.casemodule.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/user/{idAccount}")
public class UMessageControllerAPI {
    @Autowired
    private IMessageService messageService;
    @Autowired
    private IFriendshipService friendshipService;
    @Autowired
    private IAccountService accountService;
    @GetMapping("/messages")
    public ResponseEntity<List<Message>> getAllMessageByAccountId(@PathVariable int idAccount) {
        return new ResponseEntity<>(messageService.getAllMessageByAccountId(idAccount), HttpStatus.OK);
    }
    @GetMapping("/messages/{idSender}")
    public ResponseEntity<List<Message>> getAllMessageBySenderId(@PathVariable int idAccount, @PathVariable int idSender) {
        return new ResponseEntity<>(messageService.getAllMessageBySenderId(idAccount, idSender), HttpStatus.OK);
    }
    @GetMapping("/messages/{idSender}/last")
    public ResponseEntity<Message> getLastMessageBySenderId(@PathVariable int idAccount, @PathVariable int idSender) {
        return new ResponseEntity<>(messageService.getLastMessageBySenderId(idAccount, idSender), HttpStatus.OK);
    }
    @GetMapping("/messages/last")
    public ResponseEntity<List<Message>> getAllLastMessageByAccountId(@PathVariable int idAccount) {
        return new ResponseEntity<>(messageService.getAllLastMessageByAccountId(idAccount), HttpStatus.OK);
    }
    @GetMapping("/messages/all")
    public ResponseEntity<List<AllFriendMessage>> getAllMessageByAllFriend(@PathVariable int idAccount) {
        List<Friendship> friendshipList = friendshipService.getAllFriendshipByAccountId(idAccount);
        return new ResponseEntity<>(messageService.getAllFriendMessage(idAccount, friendshipList), HttpStatus.OK);
    }
    @PostMapping("/messages/{idReceiver}")
    ResponseEntity<Message> sendMessage(@PathVariable int idAccount,
                                        @PathVariable int idReceiver, @RequestBody Message message) {
        LocalDateTime now = LocalDateTime.now();
        message.setCreateAt(Timestamp.valueOf(now));
        Account sender = accountService.findById(idAccount);
        Account receiver = accountService.findById(idReceiver);
        message.setSender(sender);
        message.setReceiver(receiver);
        messageService.save(message);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
