package com.casemodule.service.impl;

import com.casemodule.model.Account;
import com.casemodule.model.Comment;
import com.casemodule.model.Post;
import com.casemodule.model.dto.CommentWithPost;
import com.casemodule.repository.ICommentRepo;
import com.casemodule.service.ICommentService;
import com.casemodule.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    private ICommentRepo iCommentRepo;
    @Autowired
    private IPostService postService;
    @Override
    public List<Comment> getAllCommentByPostId(int id) {
        return iCommentRepo.getAllCommentByPostId(id);
    }

    @Override
    public void save(Comment comment) {
        iCommentRepo.save(comment);
    }

    @Override
    public void edit(Comment comment) {
        iCommentRepo.save(comment);
    }

    @Override
    public void delete(int id) {
        iCommentRepo.deleteById(id);
    }

    @Override
    public Comment findById(int id) {
        Optional<Comment> commentOptional = iCommentRepo.findById(id);
        return commentOptional.orElse(null);
    }

    @Override
    public List<CommentWithPost> getAllCommentWithPost(int idAccount) {
        List<Post> posts = postService.getAllPostByAccountId(idAccount);
        List<CommentWithPost> commentWithPostList = new ArrayList<>();
        for (Post post : posts) {
            List<Comment> commentList = getAllCommentByPostId(post.getId());
            CommentWithPost commentWithPost = new CommentWithPost(post, commentList);
            commentWithPostList.add(commentWithPost);
        }
        return commentWithPostList;
    }
}
