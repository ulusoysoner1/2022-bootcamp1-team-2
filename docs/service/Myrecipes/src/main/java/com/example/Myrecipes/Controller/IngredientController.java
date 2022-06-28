package com.example.Myrecipes.Controller;

import com.example.Myrecipes.Exception.IngredientNotFoundException;
import com.example.Myrecipes.Model.Ingredient;
import com.example.Myrecipes.Repository.IngredientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IngredientController {

    private final IngredientRepository repository;

    public IngredientController(IngredientRepository repository){
        this.repository = repository;
    }

    @GetMapping("/ingredients")
    List<Ingredient> all() {
        return repository.findAll();
    }

    @PostMapping("/ingredients")
    Ingredient createIngredient(@RequestBody Ingredient newIngredient){
        return repository.save(newIngredient);
    }

    @GetMapping("/ingredients/{id}")
    Ingredient readIngredient(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(() -> new IngredientNotFoundException(id));
    }

    @PutMapping("/ingredients/{id}")
    Ingredient updateIngredient(@RequestBody Ingredient newIngredient, @PathVariable Integer id){
        return repository.findById(id).map(ingredient -> {
            ingredient.setDescription(newIngredient.getDescription());
            return repository.save(ingredient);
        }).orElseGet(() -> {
            newIngredient.setId(id);
            return repository.save(newIngredient);
        });
    }

    @DeleteMapping("/ingredients/{id}")
    void deleteIngredient(@PathVariable Integer id ){
        repository.deleteById(id);
    }
}
