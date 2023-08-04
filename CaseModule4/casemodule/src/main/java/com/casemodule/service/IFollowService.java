package com.casemodule.service;

import com.casemodule.model.Follow;

public interface IFollowService {
    Follow getFollowByAccountId(int id);
}
