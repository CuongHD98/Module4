package com.casemodule.repository;

import com.casemodule.model.Comment;
import com.casemodule.model.FriendRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFriendRequestRepo extends JpaRepository<FriendRequest, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM Friend_Request where receiver_id= :receiver_id")
    List<FriendRequest> getAllFriendRequestByAccountId(@Param("receiver_id") int receiver_id);
}
