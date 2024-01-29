package com.example.recipe;

import java.util.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class RecipeController {

    RecipeService r = new RecipeService();

    @GetMapping("/recipes")
    public ArrayList<Recipe> getRecipes() {
        return r.getRecipes();
    }

    @GetMapping("/recipes/{recipeId}")
    public Recipe getRecipeById(@PathVariable("recipeId") int id) {
        return r.getRecipeById(id);
    }

    @PostMapping("/recipes")
    public Recipe postRecipe(@RequestBody Recipe recipe) {
        return r.postRecipe(recipe);
    }

    @PutMapping("/recipes/{recipeId}")
    public Recipe putRecipe(@PathVariable("recipeId") int id, @RequestBody Recipe recipe) {
        return r.updateRecipe(id, recipe);
    }

    @DeleteMapping("/recipes/{recipeId}")
    public void deleteRecipe(@PathVariable("recipeId") int id) {
        r.deleteRecipe(id);
    }

}