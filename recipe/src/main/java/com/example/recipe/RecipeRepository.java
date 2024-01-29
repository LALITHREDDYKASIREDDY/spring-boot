package com.example.recipe;

import java.util.*;

interface RecipeRepository {
    ArrayList<Recipe> getRecipes();

    Recipe getRecipeById(int id);

    Recipe postRecipe(Recipe recipe);

    Recipe updateRecipe(int id, Recipe recipe);

    void deleteRecipe(int id);

}