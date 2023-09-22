package com.example;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    Cat testCat = new Cat(new Feline());

    @Test
    public void testGetSound(){
        String expectedSound = "Мяу";
        Assertions.assertEquals(expectedSound, testCat.getSound());
    }
    @Test
    public void testCatFood() throws Exception {

        List<String> actualCatFood = testCat.getFood();
        String actualFood = String.join(", ", actualCatFood);

        List<String> expectedCatFood = List.of("Животные", "Птицы", "Рыба");
        String expectedFood = String.join(", ", expectedCatFood);

        Assertions.assertEquals(expectedFood, actualFood);
    }
    @Spy
    Feline felineSpy = new Feline();

    @Test
    public void testCatFoodSpy() throws Exception {
        Cat testCat = new Cat(felineSpy);
        List<String> actualCatFood = testCat.getFood();
        Mockito.verify(testCat.predator,Mockito.times(1)).eatMeat();

    }

}
