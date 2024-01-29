package com.example.recipe;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;



public class RecipeService implements RecipeRepository {

    private static HashMap<Integer, Recipe> recipeBook = new HashMap<>();
    private int id = 6;

    public RecipeService() {
        recipeBook.put(1,
                new Recipe(1, "Pasta", "veg",
                        Arrays.asList("pasta", "tomatoes", "olive oil", "garlic", "basil")));
        recipeBook.put(2, new Recipe(2, "Chicken Curry", "non-veg",
                Arrays.asList("chicken", "onion", "tomato", "ginger", "garlic", "spices")));
        recipeBook.put(3, new Recipe(3, "Sushi", "non-veg",
                Arrays.asList("sushi rice", "tuna fish", "seaweed", "wasabi", "ginger")));
        recipeBook.put(4, new Recipe(4, "Mushroom Risotto", "veg",
                Arrays.asList("rice", "mushrooms", "onion", "garlic", "butter", "parmesan")));
        recipeBook.put(5, new Recipe(5, "Fish and Chips", "non-veg",
                Arrays.asList("fish", "potatoes", "flour", "oil", "spices")));
    }

    @Override
    public ArrayList<Recipe> getRecipes() {
        Collection<Recipe> recipes = recipeBook.values();
        ArrayList<Recipe> recipe = new ArrayList<>(recipes);
        return recipe;
    }

    @Override
    public Recipe getRecipeById(int id) {
        Recipe recipe = recipeBook.get(id);
        if (recipe == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return recipe;
    }

    @Override
    public Recipe postRecipe(Recipe recipe) {
        recipe.setRecipeId(id);
        recipeBook.put(id, recipe);
        id++;
        return recipe;
    }

    @Override
    public Recipe updateRecipe(int id, Recipe recipe) {
        Recipe original = recipeBook.get(id);
        if (original == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (recipe.getRecipeName() != null) {
            original.setRecipeName(recipe.getRecipeName());
        }
        if (recipe.getRecipeType() != null) {
            original.setRecipeType(recipe.getRecipeType());
        }
        if (recipe.getIngredients() != null) {
            original.setIngredients(recipe.getIngredients());
        }
        recipeBook.put(id, original);
        return original;
    }

    @Override
    public void deleteRecipe(int id) {
        Recipe recipe = recipeBook.get(id);
        if (recipe == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        recipeBook.remove(id);
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }
}