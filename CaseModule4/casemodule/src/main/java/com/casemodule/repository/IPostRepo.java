package com.casemodule.repository;

import com.casemodule.model.Account;
import com.casemodule.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPostRepo extends JpaRepository<Post, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM Post where account_id= :account_id")
    List<Post> getAllPostByAccountId(@Param("account_id") int account_id);
}
