package com.casemodule.service;

import com.casemodule.model.Account;
import com.casemodule.model.Friendship;
import com.casemodule.model.Message;
import com.casemodule.model.dto.AllFriendMessage;

import java.util.ArrayList;
import java.util.List;

public interface IMessageService {
    List<Message> getAllMessageByAccountId(int id);
    List<Message> getAllMessageBySenderId(int idReceiver, int idSender);
    Message getLastMessageBySenderId(int idReceiver, int idSender);
    List<Message> getAllLastMessageByAccountId(int id);
    List<AllFriendMessage> getAllFriendMessage(int idAccount, List<Friendship> friendList);
    void save(Message message);
}
