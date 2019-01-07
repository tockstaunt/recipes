package com.keithcollier.recipes.service;

import com.keithcollier.recipes.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}
