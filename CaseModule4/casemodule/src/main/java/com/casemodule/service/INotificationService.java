package com.casemodule.service;

import com.casemodule.model.Notification;

import java.util.List;

public interface INotificationService {
    List<Notification> getAllNotificationByAccountId(int id);
    void deleteNotification(int id);
    Notification findById(int id);
}
