package com.keithcollier.recipes.repositories;

import com.keithcollier.recipes.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepoTestIT {

    @Autowired
    UnitOfMeasureRepo unitOfMeasureRepo;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void findByDescriptionTeaspoon() throws  Exception{

        Optional<UnitOfMeasure> unit = unitOfMeasureRepo.findByDescription("Teaspoon");
        assertEquals("Teaspoon", unit.get().getDescription());


    }

    @Test
    public void findByDescriptionCup() throws  Exception{

        Optional<UnitOfMeasure> unit = unitOfMeasureRepo.findByDescription("Cup");
        assertEquals("Cup", unit.get().getDescription());


    }
}