package com.example.myrecipes.recipe;

public class RecipeNotFoundException extends RuntimeException {
    public RecipeNotFoundException(Integer id) {
        super("Could not find recipe " + id);
    }
}
