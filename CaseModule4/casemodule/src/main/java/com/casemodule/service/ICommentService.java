package com.casemodule.service;

import com.casemodule.model.Comment;
import com.casemodule.model.Post;
import com.casemodule.model.dto.CommentWithPost;

import java.util.List;

public interface ICommentService {
    List<Comment> getAllCommentByPostId(int id);
    void save(Comment comment);
    void edit(Comment comment);
    void delete(int id);
    Comment findById(int id);
    List<CommentWithPost> getAllCommentWithPost(int idAccount);
}
