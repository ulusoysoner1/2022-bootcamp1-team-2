package com.example.Myrecipes.Exception;

public class CommentNotFoundException extends RuntimeException{
    public CommentNotFoundException(Integer id){ super("Could not find employee " + id);}
}
