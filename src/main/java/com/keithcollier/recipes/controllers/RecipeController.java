package com.keithcollier.recipes.controllers;

import com.keithcollier.recipes.repositories.CatagoryRepo;
import com.keithcollier.recipes.repositories.RecipeRepo;
import com.keithcollier.recipes.repositories.UnitOfMeasureRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class RecipeController {

    private CatagoryRepo catagoryRepo;
    private UnitOfMeasureRepo unitOfMeasureRepo;
    private RecipeRepo recipeRepo;

    public RecipeController(CatagoryRepo catagoryRepo, UnitOfMeasureRepo unitOfMeasureRepo, RecipeRepo recipeRepo) {
        this.catagoryRepo = catagoryRepo;
        this.unitOfMeasureRepo = unitOfMeasureRepo;
        this.recipeRepo = recipeRepo;
    }


    @RequestMapping({"","/","index","/index.html"})
    public String index(Model model){

        model.addAttribute("rec", recipeRepo.findAll());

        return "index";
    }
}
