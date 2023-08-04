package com.casemodule.service.impl;

import com.casemodule.model.Follow;
import com.casemodule.repository.IFollowRepo;
import com.casemodule.service.IFollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowServiceImpl implements IFollowService {
    @Autowired
    private IFollowRepo iFollowRepo;
    @Override
    public Follow getFollowByAccountId(int id) {
        return (Follow) iFollowRepo.getFollowByAccountId(id);
    }
}
