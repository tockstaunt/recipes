package com.keithcollier.recipes.service;

import com.keithcollier.recipes.domain.Recipe;
import com.keithcollier.recipes.repositories.RecipeRepo;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService{

    private final RecipeRepo recipeRepo;

    public RecipeServiceImpl(RecipeRepo recipeRepo) {
        this.recipeRepo = recipeRepo;
    }

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepo.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }
}
