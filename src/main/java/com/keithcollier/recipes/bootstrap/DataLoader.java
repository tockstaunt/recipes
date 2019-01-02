package com.keithcollier.recipes.bootstrap;

import com.keithcollier.recipes.models.Recipe;
import com.keithcollier.recipes.services.RecService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final RecService recService;

    public DataLoader(RecService recService) {
        this.recService = recService;
    }

    @Override
    public void run(String... arg) throws Exception{

        Recipe rec = new Recipe();
        rec.setRecipe("recipe 1");

        recService.save(rec);


        Recipe rec1 = new Recipe();
        rec1.setRecipe("recipe 2");

        recService.save(rec1);

        Recipe rec2 = new Recipe();
        rec2.setRecipe("recipe 3");

        recService.save(rec2);
    }
}
