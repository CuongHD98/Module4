package com.casemodule.repository;

import com.casemodule.model.FriendRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFriendRequestRepo extends JpaRepository<FriendRequest, Integer> {
}
