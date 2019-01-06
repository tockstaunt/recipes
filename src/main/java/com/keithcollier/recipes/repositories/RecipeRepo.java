package com.keithcollier.recipes.repositories;

import com.keithcollier.recipes.domain.*;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface RecipeRepo extends CrudRepository<Recipe, Long> {

    Optional<Recipe> findByDescription(String description);
    Optional<Recipe> findByCookTime(Integer cookTime);
    Optional<Recipe> findByPrepTime(Integer prepTime);
    Optional<Recipe> findByServingsMin(Integer servingsMin);
    Optional<Recipe> findByServingsMax(Integer servingsMax);
    Optional<Recipe> findBySource(String source);
    Optional<Recipe> findByUrl(String url);
    Optional<Recipe> findByDirections(String directions);
    Optional<Recipe> findByIngredients(Set<Ingredient> ingredients);
    Optional<Recipe> findByImage(Byte[] image);
    Optional<Recipe> findByDifficulty(Difficulty difficulty);
    Optional<Recipe> findByNotes(Notes notes);
    Optional<Recipe> findByCategories(Set<Category> categories);


}
