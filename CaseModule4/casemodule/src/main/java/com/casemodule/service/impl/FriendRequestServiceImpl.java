package com.casemodule.service.impl;

import com.casemodule.model.FriendRequest;
import com.casemodule.model.Post;
import com.casemodule.repository.IFriendRequestRepo;
import com.casemodule.service.IFriendRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FriendRequestServiceImpl implements IFriendRequestService {
    @Autowired
    private IFriendRequestRepo iFriendRequestRepo;
    @Override
    public List<FriendRequest> getAllFriendRequestByAccountId(int id) {
        return iFriendRequestRepo.getAllFriendRequestByAccountId(id);
    }

    @Override
    public void updateFriendRequest(FriendRequest friendRequest) {
        iFriendRequestRepo.save(friendRequest);
        if (friendRequest.getStatus().getStatus().equals("Solved")) {
            deleteFriendRequest(friendRequest.getId());
        }
    }

    @Override
    public void deleteFriendRequest(int id) {
        iFriendRequestRepo.deleteById(id);
    }

    @Override
    public void createFriendRequest(FriendRequest friendRequest) {
        iFriendRequestRepo.save(friendRequest);
    }

    @Override
    public FriendRequest findById(int id) {
        Optional<FriendRequest> friendRequestOptional = iFriendRequestRepo.findById(id);
        return friendRequestOptional.orElse(null);
    }
}
