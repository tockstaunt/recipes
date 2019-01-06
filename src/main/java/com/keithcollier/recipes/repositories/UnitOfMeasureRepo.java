package com.keithcollier.recipes.repositories;

import com.keithcollier.recipes.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

public interface UnitOfMeasureRepo extends CrudRepository<UnitOfMeasure, Long> {
}
