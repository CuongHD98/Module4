package com.casemodule.service;

import com.casemodule.model.FriendRequest;

import java.util.List;

public interface IFriendRequestService {
    List<FriendRequest> getAllFriendRequestByAccountId(int id);
    void updateFriendRequest(FriendRequest friendRequest);
    void deleteFriendRequest(int id);
    void createFriendRequest(FriendRequest friendRequest);
    FriendRequest findById(int id);
}
