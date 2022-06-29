package com.example.Myrecipes.Controller;

import com.example.Myrecipes.Exception.RecipeNotFoundException;
import com.example.Myrecipes.Model.Recipe;
import com.example.Myrecipes.Repository.RecipeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeController {

    private final RecipeRepository repository;

    public RecipeController(RecipeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/recipes")
    List<Recipe> all() {
        return repository.findAll();
    }

    @PostMapping("/recipes")
    Recipe createRecipe(@RequestBody Recipe newRecipe) {
        return repository.save(newRecipe);
    }

    @GetMapping("/recipes/{id}")
    Recipe readRecipe(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow(() -> new RecipeNotFoundException(id));
    }

    @PutMapping("/recipes/{id}")
    Recipe updateRecipe(@RequestBody Recipe newRecipe, @PathVariable Integer id) {
        return repository.findById(id).map(recipe -> {
            recipe.setTitle(newRecipe.getTitle());
            recipe.setCategory(newRecipe.getCategory());
            recipe.setNop(newRecipe.getNop());
            recipe.setCookingTime(newRecipe.getCookingTime());
            recipe.setCookingDegree(newRecipe.getCookingDegree());
            recipe.setPicture(newRecipe.getPicture());
            recipe.setUsers_id(newRecipe.getUsers_id());
            return repository.save(recipe);
        }).orElseGet(() -> {
            newRecipe.setId(id);
            return repository.save(newRecipe);
        });
    }

    @DeleteMapping("/recipes/{id}")
    void deleteRecipe(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
