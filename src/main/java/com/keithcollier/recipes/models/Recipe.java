package com.keithcollier.recipes.models;

import javax.persistence.Entity;

@Entity
public class Recipe extends BaseEntity {


    private String recipe;

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }
}
