package com.casemodule.service.impl;

import com.casemodule.model.Notification;
import com.casemodule.model.Post;
import com.casemodule.repository.INotificationRepo;
import com.casemodule.service.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationServiceImpl implements INotificationService {
    @Autowired
    private INotificationRepo iNotificationRepo;
    @Override
    public List<Notification> getAllNotificationByAccountId(int id) {
        return iNotificationRepo.getAllNotificationByAccountId(id);
    }

    @Override
    public void deleteNotification(int id) {
        iNotificationRepo.deleteById(id);
    }

    @Override
    public Notification findById(int id) {
        Optional<Notification> notificationOptional = iNotificationRepo.findById(id);
        return notificationOptional.orElse(null);
    }
}
