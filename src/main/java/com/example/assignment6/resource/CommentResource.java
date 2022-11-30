package com.example.assignment6.resource;


import com.example.assignment6.model.Comment;
import com.example.assignment6.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/comments")
@CrossOrigin
public class CommentResource {
    @Autowired
    private CommentService commentService;

    //POST  methods
    @PostMapping
    public Comment saveComment(@RequestBody @Valid Comment comment){
        return commentService.saveComment(comment);
    }

    @GetMapping
    public List<Comment> getAllComment(){
        return commentService.getAllComment();
    }

    @GetMapping("/find")
    public Comment getCommentById(@RequestParam("id")String id){
        return commentService.getCommentById(id);
    }

    //PUT methods
    @PutMapping
    public Comment updateComment( @RequestBody Comment comment){
        return commentService.updateComment(comment);
    }
    //DELETE methods
    @DeleteMapping
    public void deleteComment(@RequestParam(name = "id")String id){
          commentService.deleteComment(id);
    }
    /*

    @GetMapping("/comment/{id}")
    public Comment getCommentById(@PathVariable("id") int id){
        return commentService.getCommentById(id);
    }





     */
}
