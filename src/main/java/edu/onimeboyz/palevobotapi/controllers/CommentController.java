package edu.onimeboyz.palevobotapi.controllers;

import edu.onimeboyz.palevobotapi.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import edu.onimeboyz.palevobotapi.entities.Comment;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/comments")
public class CommentController  {

    @Autowired
    CommentRepository commentRepository;
    @GetMapping
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @PostMapping
    public Comment createComment(@Valid @RequestBody Comment comment) {
        return commentRepository.save(comment);
    }

    @GetMapping("/{palevo_id}")
    public Comment getCommentByPalevoId(@PathVariable(value = "palevo_id") Integer palevoId) {
        return commentRepository.findAll().stream()
                .filter(comment -> comment.getPalevo().getId() == palevoId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Wrong palevo_id"));
    }

    @GetMapping("/{comment_id}")
    public Comment getCommentById(@PathVariable(value = "comment_id") Integer commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("Wrong comment_id"));
    }


    @PutMapping("/{comment_id}")
    public Comment updateNote(@PathVariable(value = "comment_id") Integer commentId,
                           @Valid @RequestBody Comment commentDetails) {

        Comment comment = getCommentById(commentId);
        comment.setContent(commentDetails.getContent());
        comment.setPalevo(commentDetails.getPalevo());
        return commentRepository.save(comment);
    }


    @DeleteMapping("/comment_id")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "comment_id") Integer commentId) {

        Comment comment = getCommentById(commentId);
        commentRepository.delete(comment);
        return ResponseEntity.ok().build();
    }
}
