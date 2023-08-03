package com.casemodule.service;

import com.casemodule.model.Post;

import java.util.List;

public interface IPostService {
    List<Post> getAllPostByAccountId(int id);
    void save(Post post);
    void edit(Post post);
    void delete(int id);
    Post findById(int id);
}
