package com.casemodule.service;

import com.casemodule.model.Friendship;

import java.util.List;

public interface IFriendshipService {
    List<Friendship> getAllFriendshipByAccountId(int id);
    void createFriendship(Friendship friendship);
    void deleteFriendship(int id);
    Friendship findById(int id);
}
