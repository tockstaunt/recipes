package com.keithcollier.recipes.controllers;

import com.keithcollier.recipes.services.RecService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController {

    private final RecService recService;

    public RecipeController(RecService recService) {
        this.recService = recService;
    }

    @RequestMapping({"","/","index"})
    public String listRecipes(Model model){

        System.out.println("recipe index html loaded...");
        model.addAttribute("rec", recService.findAll());
        return "index" ;
    }
}
