package com.keithcollier.recipes.repositories;

import com.keithcollier.recipes.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface CatagoryRepo extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String description);
}
