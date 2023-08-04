package com.casemodule.service.impl;

import com.casemodule.model.Friendship;
import com.casemodule.model.Post;
import com.casemodule.repository.IFriendshipRepo;
import com.casemodule.service.IFriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FriendshipServiceImpl implements IFriendshipService {
    @Autowired
    private IFriendshipRepo iFriendshipRepo;
    @Override
    public List<Friendship> getAllFriendshipByAccountId(int id) {
        return iFriendshipRepo.getAllFriendshipByAccountId(id);
    }

    @Override
    public void createFriendship(Friendship friendship) {
        iFriendshipRepo.save(friendship);
    }

    @Override
    public void deleteFriendship(int id) {
        iFriendshipRepo.deleteById(id);
    }

    @Override
    public Friendship findById(int id) {
        Optional<Friendship> friendshipOptional = iFriendshipRepo.findById(id);
        return friendshipOptional.orElse(null);
    }
}
