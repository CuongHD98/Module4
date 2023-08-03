package com.casemodule.service.impl;

import com.casemodule.model.Account;
import com.casemodule.model.Comment;
import com.casemodule.repository.ICommentRepo;
import com.casemodule.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    private ICommentRepo iCommentRepo;
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
}
