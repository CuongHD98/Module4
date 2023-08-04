package com.casemodule.repository;

import com.casemodule.model.FriendRequest;
import com.casemodule.model.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFriendshipRepo extends JpaRepository<Friendship, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM Friendship where user_id= :user_id")
    List<Friendship> getAllFriendshipByAccountId(@Param("user_id") int user_id);
}
