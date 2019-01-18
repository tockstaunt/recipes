package com.keithcollier.recipes.service;

import com.keithcollier.recipes.domain.Recipe;
import com.keithcollier.recipes.repositories.RecipeRepo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepo recipeRepo;

    @Before
    public void setUo(){

        MockitoAnnotations.initMocks(this);

        recipeService = new RecipeServiceImpl(recipeRepo);
    }

    @Test
    public void getRecipes() throws Exception{

        Recipe recipe = new Recipe();
        HashSet recipeData = new HashSet();
        recipeData.add(recipe);

        when(recipeService.getRecipes()).thenReturn(recipeData);

        Set<Recipe> recipeSet = recipeService.getRecipes();

        assertEquals(recipeSet.size(), 1);
        verify(recipeRepo, times(1)).findAll();
    }
}