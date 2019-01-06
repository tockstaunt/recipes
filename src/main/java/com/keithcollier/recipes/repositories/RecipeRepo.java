package com.keithcollier.recipes.repositories;

import com.keithcollier.recipes.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepo extends CrudRepository<Recipe, Long> {
}
