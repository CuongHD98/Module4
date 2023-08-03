package com.casemodule.service;

import com.casemodule.model.Comment;

import java.util.List;

public interface ICommentService {
    List<Comment> getAllCommentByPostId(int id);
    void save(Comment comment);
    void edit(Comment comment);
    void delete(int id);
    Comment findById(int id);
}
