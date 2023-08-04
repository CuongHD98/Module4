package com.casemodule.model.dto;

import com.casemodule.model.Account;
import com.casemodule.model.Message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AllFriendMessage {
    private Account user;
    private Account friend;
    private List<Message> messageList;
}
