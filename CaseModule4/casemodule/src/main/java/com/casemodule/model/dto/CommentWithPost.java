package com.casemodule.model.dto;

import com.casemodule.model.Comment;
import com.casemodule.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentWithPost {
    private Post post;
    private List<Comment> commentList;
}
