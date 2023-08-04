package com.casemodule.controller.user;

import com.casemodule.model.Notification;
import com.casemodule.service.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/user/{idAccount}")
public class UNotificationControllerAPI {
    @Autowired
    private INotificationService notificationService;
    @GetMapping("/notifications")
    public ResponseEntity<List<Notification>> getAllNotificationByAccountId(@PathVariable int idAccount) {
        return new ResponseEntity<>(notificationService.getAllNotificationByAccountId(idAccount), HttpStatus.OK);
    }
    @GetMapping("/notifications/{idNotification}")
    public ResponseEntity<Notification> deleteNotification(@PathVariable int idNotification) {
        Notification notification = notificationService.findById(idNotification);
        notificationService.deleteNotification(idNotification);
        return new ResponseEntity<>(notification, HttpStatus.OK);
    }

}
