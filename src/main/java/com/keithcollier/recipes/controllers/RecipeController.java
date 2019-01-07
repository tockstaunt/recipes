package com.keithcollier.recipes.controllers;

import com.keithcollier.recipes.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class RecipeController {

  private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","index","/index.html"})
    public String index(Model model){

        model.addAttribute("rec", recipeService.getRecipes());

        return "index";
    }
}
