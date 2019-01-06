package com.keithcollier.recipes.repositories;

import com.keithcollier.recipes.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CatagoryRepo extends CrudRepository<Category, Long> {
}
