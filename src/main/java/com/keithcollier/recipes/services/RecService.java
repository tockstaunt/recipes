package com.keithcollier.recipes.services;

import com.keithcollier.recipes.models.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface RecService extends CrudRepository<Recipe, Long> {

}
