package com.casemodule.repository;

import com.casemodule.model.Account;
import com.casemodule.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommentRepo extends JpaRepository<Comment, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM Comment where post_id= :post_id")
    List<Comment> getAllCommentByPostId(@Param("post_id") int post_id);

}
