package com.keithcollier.recipes.repositories;

import com.keithcollier.recipes.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.Optional;

public interface IngredientRepo extends CrudRepository<Ingredient, Long> {

    Optional<Ingredient> findByDescription(String description);
    Optional<Ingredient> findByAmount(BigDecimal amount);
}
