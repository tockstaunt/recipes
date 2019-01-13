package com.keithcollier.recipes.bootstrap;

import com.keithcollier.recipes.domain.*;
import com.keithcollier.recipes.repositories.CatagoryRepo;
import com.keithcollier.recipes.repositories.RecipeRepo;
import com.keithcollier.recipes.repositories.UnitOfMeasureRepo;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private CatagoryRepo catagoryRepo;
    private UnitOfMeasureRepo unitOfMeasureRepo;
    private RecipeRepo recipeRepo;

    public RecipeBootstrap(CatagoryRepo catagoryRepo, UnitOfMeasureRepo unitOfMeasureRepo, RecipeRepo recipeRepo) {
        this.catagoryRepo = catagoryRepo;
        this.unitOfMeasureRepo = unitOfMeasureRepo;
        this.recipeRepo = recipeRepo;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepo.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes(){
        List<Recipe> recipes = new ArrayList<>(2);

        Optional<UnitOfMeasure> eachUOMOptional = unitOfMeasureRepo.findByDescription("Each");

        if(!eachUOMOptional.isPresent()){
            throw new RuntimeException("Expected uom not found");
        }

        Optional<UnitOfMeasure> tableSpoonUOMOptional = unitOfMeasureRepo.findByDescription("Tablespoon");

        if(!tableSpoonUOMOptional.isPresent()){
            throw new RuntimeException("Expected uom not found");
        }

        Optional<UnitOfMeasure> teaSpoonUOMOptional = unitOfMeasureRepo.findByDescription("Teaspoon");

        if(!teaSpoonUOMOptional.isPresent()){
            throw new RuntimeException("Expected uom not found");
        }

        Optional<UnitOfMeasure> dashUOMOptional = unitOfMeasureRepo.findByDescription("Dash");

        if(!dashUOMOptional.isPresent()){
            throw new RuntimeException("Expected uom not found");
        }

        Optional<UnitOfMeasure> pintUOMOptional = unitOfMeasureRepo.findByDescription("Pinch");

        if(!pintUOMOptional.isPresent()){
            throw new RuntimeException("Expected uom not found");
        }

        Optional<UnitOfMeasure> cupUOMOptional = unitOfMeasureRepo.findByDescription("Cup");

        if(!cupUOMOptional.isPresent()){
            throw new RuntimeException("Expected uom not found");
        }

        //get Optionals
        UnitOfMeasure eachUOM = eachUOMOptional.get();
        UnitOfMeasure tableSpoonUOM = tableSpoonUOMOptional.get();
        UnitOfMeasure teaSpoonUOM = teaSpoonUOMOptional.get();
        UnitOfMeasure dashUOM = dashUOMOptional.get();
        UnitOfMeasure pintUOM = pintUOMOptional.get();
        UnitOfMeasure cupUOM = cupUOMOptional.get();

        Optional<Category> americanCategoryOptional = catagoryRepo.findByDescription("American");

        if(!americanCategoryOptional.isPresent()){
            throw new RuntimeException("Ecpected Category not found");
        }

        Optional<Category> mexicanCategoryOptional = catagoryRepo.findByDescription("Mexican");

        if(!mexicanCategoryOptional.isPresent()){
            throw new RuntimeException("Ecpected Category not found");
        }

        Category americanCategory = americanCategoryOptional.get();
        Category mexocanCategory = mexicanCategoryOptional.get();

        Recipe guacRecipe = new Recipe();
        guacRecipe.setDescription("Perfect Guac");
        guacRecipe.setPrepTime(10);
        guacRecipe.setCookTime(0);
        guacRecipe.setDifficulty(Difficulty.EASY);
        guacRecipe.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
                "\n" +
                "\n" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
                "\n" +
                "\n" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "\n" +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                "\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n" +
                "\n" +
                "Variations\n" +
                "\n" +
                "For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries (see our Strawberry Guacamole).\n" +
                "\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" +
                "\n" +
                "For a deviled egg version with guacamole, try our Guacamole Deviled Eggs!");

        Notes guacNotes = new Notes();
        guacNotes.setRecipeNotes("Be careful handling chiles if using. Wash your hands thoroughly after handling and do not touch your eyes or the area near your eyes with your hands for several hours.");
        guacRecipe.setNotes(guacNotes);

        guacRecipe.getIngredients().add(new Ingredient("Ripe Avocados",new BigDecimal(2),eachUOM));
        guacRecipe.getIngredients().add(new Ingredient("Salt",new BigDecimal(.5),teaSpoonUOM));
        guacRecipe.getIngredients().add(new Ingredient("limon or lime juice",new BigDecimal(2),tableSpoonUOM));
        guacRecipe.getIngredients().add(new Ingredient("minced red onion",new BigDecimal(2),tableSpoonUOM));
        guacRecipe.getIngredients().add(new Ingredient("Cilantro",new BigDecimal(2),tableSpoonUOM));
        guacRecipe.getIngredients().add(new Ingredient("black pepper",new BigDecimal(.5),dashUOM));
        guacRecipe.getIngredients().add(new Ingredient("ripe tomato",new BigDecimal(0.5),eachUOM));

        guacRecipe.getCategories().add(americanCategory);
        guacRecipe.getCategories().add(mexocanCategory);

        Recipe tacoRecipe = new Recipe();
        tacoRecipe.setDescription("Spicy Grilled Taco");
        tacoRecipe.setPrepTime(20);
        tacoRecipe.setCookTime(15);
        tacoRecipe.setDifficulty(Difficulty.MODERATE);

        tacoRecipe.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "\n" +
                "Spicy Grilled Chicken Tacos\n" +
                "\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.");

        Notes tacoNotes = new Notes();
        tacoNotes.setRecipeNotes("Look for ancho chile powder with the Mexican ingredients at your grocery store, on buy it online. (If you can't find ancho chili powder, you replace the ancho chili, the oregano, and the cumin with 2 1/2 tablespoons regular chili powder, though the flavor won't be quite the same.)");


        tacoRecipe.setNotes(tacoNotes);


        tacoRecipe.getIngredients().add(new Ingredient("ancho chili powder",new BigDecimal(2),tableSpoonUOM));
        tacoRecipe.getIngredients().add(new Ingredient("Dried oregano",new BigDecimal(1),teaSpoonUOM));
        tacoRecipe.getIngredients().add(new Ingredient("dried cumin",new BigDecimal(1),teaSpoonUOM));
        tacoRecipe.getIngredients().add(new Ingredient("sugar",new BigDecimal(1),teaSpoonUOM));
        tacoRecipe.getIngredients().add(new Ingredient("salt",new BigDecimal(.5),teaSpoonUOM));
        tacoRecipe.getIngredients().add(new Ingredient("clove garlic, finely chopped",new BigDecimal(1),eachUOM));
        tacoRecipe.getIngredients().add(new Ingredient("finely grated orange zest",new BigDecimal(1),tableSpoonUOM));
        tacoRecipe.getIngredients().add(new Ingredient("fresh-squeezed orange juice",new BigDecimal(3),tableSpoonUOM));
        tacoRecipe.getIngredients().add(new Ingredient("olive oil",new BigDecimal(2),tableSpoonUOM));
        tacoRecipe.getIngredients().add(new Ingredient("boneless chicken thighs (1 1/4 pounds)",new BigDecimal(4),eachUOM));

        tacoRecipe.getCategories().add(americanCategory);
        tacoRecipe.getCategories().add(mexocanCategory);

        recipes.add(guacRecipe);
        recipes.add(tacoRecipe);
        System.out.println("Bootstrap data loaded...");

        return recipes;
    }
}
