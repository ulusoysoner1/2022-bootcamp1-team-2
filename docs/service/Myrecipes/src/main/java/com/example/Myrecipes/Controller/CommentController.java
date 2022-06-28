package com.example.Myrecipes.Controller;

import com.example.Myrecipes.Exception.CommentNotFoundException;
import com.example.Myrecipes.Model.Comment;
import com.example.Myrecipes.Repository.CommentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    private final CommentRepository repository;

    public CommentController(CommentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/comments")
    List<Comment> all() {
        return repository.findAll();
    }

    @PostMapping("/comments")
    Comment newComment(@RequestBody Comment newComment){
        return repository.save(newComment);
    }

    @GetMapping("/comments/{id}")
    Comment readComment(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(() -> new CommentNotFoundException(id));
    }

    @PutMapping("/comments/{id}")
    Comment updateComment(@RequestBody Comment newComment, @PathVariable Integer id){
        return repository.findById(id).map(comment -> {
            comment.setTitle(newComment.getTitle());
            comment.setText(newComment.getText());
            comment.setC_users_id(newComment.getC_users_id());
            comment.setC_recipes_id(newComment.getC_recipes_id());
            return repository.save(comment);
        }).orElseGet(() ->{
            newComment.setId(id);
            return repository.save(newComment);
        });
    }

    @DeleteMapping("/comments/{id}")
    void deleteComment(@PathVariable Integer id){
        repository.findById(id);
    }


}
