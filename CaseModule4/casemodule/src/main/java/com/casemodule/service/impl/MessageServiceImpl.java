package com.casemodule.service.impl;

import com.casemodule.model.Account;
import com.casemodule.model.Friendship;
import com.casemodule.model.Message;
import com.casemodule.model.dto.AllFriendMessage;
import com.casemodule.repository.IMessageRepo;
import com.casemodule.service.IAccountService;
import com.casemodule.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements IMessageService {
    @Autowired
    private IMessageRepo iMessageRepo;
    @Autowired
    private IAccountService accountService;
    @Override
    public List<Message> getAllMessageByAccountId(int id) {
        return iMessageRepo.getAllMessageByAccountId(id);
    }

    @Override
    public List<Message> getAllMessageBySenderId(int idReceiver, int idSender) {
        return iMessageRepo.getAllMessageBySenderId(idReceiver, idSender);
    }

    @Override
    public Message getLastMessageBySenderId(int idReceiver, int idSender) {
        return iMessageRepo.getLastMessageBySenderId(idReceiver, idSender);
    }

    @Override
    public List<Message> getAllLastMessageByAccountId(int id) {
        return iMessageRepo.getAllLastMessageByAccountId(id);
    }
    @Override
    public List<AllFriendMessage> getAllFriendMessage(int idAccount, List<Friendship> friendList) {
        List<AllFriendMessage> allFriendMessageList = new ArrayList<>();
        for (Friendship friendship : friendList) {
            if (friendship.getUser().getId() == idAccount) {
                Account user = accountService.findById(idAccount);
                Account friend = accountService.findById(friendship.getFriend().getId());
                List<Message> messageList = iMessageRepo.getAllMessageBySenderId(idAccount, friendship.getFriend().getId());
                AllFriendMessage allFriendMessage = new AllFriendMessage(user, friend, messageList);
                allFriendMessageList.add(allFriendMessage);
            }
        }
        return allFriendMessageList;
    }

    @Override
    public void save(Message message) {
        iMessageRepo.save(message);
    }
}
