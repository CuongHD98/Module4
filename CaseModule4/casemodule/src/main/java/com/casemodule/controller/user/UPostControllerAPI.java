package com.casemodule.controller.user;

import com.casemodule.model.Account;
import com.casemodule.model.Post;
import com.casemodule.service.IAccountService;
import com.casemodule.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/user/{idAccount}")
public class UPostControllerAPI {
    @Autowired
    private IAccountService accountService;
    @Autowired
    private IPostService postService;

    @GetMapping("/posts")
    private ResponseEntity<List<Post>> getAllPostByAccountId(@PathVariable int idAccount) {
        return new ResponseEntity<>(postService.getAllPostByAccountId(idAccount), HttpStatus.OK);
    }
    @PostMapping("/posts")
    public ResponseEntity<Post> createPost(@PathVariable int idAccount, @RequestBody Post post) {
        Account account = accountService.findById(idAccount);
        post.setAccount(account);
        postService.save(post);
        return new ResponseEntity<>(post,HttpStatus.OK);
    }
    @GetMapping("/posts/{idPost}")
    public ResponseEntity<Post> deletePost(@PathVariable int idPost) {
        Post post = postService.findById(idPost);
        postService.delete(idPost);
        return new ResponseEntity<>(post,HttpStatus.OK);
    }

    @PostMapping("/posts/{idPost}")
    public ResponseEntity<Post> updatePost(@PathVariable int idAccount, @PathVariable int idPost, @RequestBody Post post) {
        post.setId(idPost);
        Account account = accountService.findById(idAccount);
        post.setAccount(account);
        postService.edit(post);
        return new ResponseEntity<>(post,HttpStatus.OK);
    }

}
