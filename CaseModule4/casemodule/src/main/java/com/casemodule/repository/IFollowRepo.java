package com.casemodule.repository;

import com.casemodule.model.Follow;
import com.casemodule.model.FriendRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IFollowRepo extends JpaRepository<Follow, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM Follow where account_id= :account_id")
    List<Follow> getFollowByAccountId(@Param("account_id") int account_id);
}
