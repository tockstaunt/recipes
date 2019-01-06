package com.keithcollier.recipes.controllers;

import com.keithcollier.recipes.domain.Category;
import com.keithcollier.recipes.domain.UnitOfMeasure;
import com.keithcollier.recipes.repositories.CatagoryRepo;
import com.keithcollier.recipes.repositories.UnitOfMeasureRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class RecipeController {

    private CatagoryRepo catagoryRepo;
    private UnitOfMeasureRepo unitOfMeasureRepo;

    public RecipeController(CatagoryRepo catagoryRepo, UnitOfMeasureRepo unitOfMeasureRepo) {
        this.catagoryRepo = catagoryRepo;
        this.unitOfMeasureRepo = unitOfMeasureRepo;
    }


    @RequestMapping({"","/"})
    public String index(){

        Optional<Category> categoryOptional = catagoryRepo.findByDescription("American");
        Optional<UnitOfMeasure> optionalUnitOfMeasure = unitOfMeasureRepo.findByDescription("Teaspoon");

        System.out.println("cat id is: "+ categoryOptional.get().getId());
        System.out.println("uom id is: "+ optionalUnitOfMeasure.get().getId());
        return "index";
    }
}
