package com.example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    Feline testFeline = new Feline();
    @Spy
    private Feline felineSpy;

    @Test
    public void testKittensEmptyArg(){
        felineSpy.getKittens();
        Mockito.verify(felineSpy).getKittens(1);
    }

    @Test
    public void testFood() throws Exception {

        List<String> actualFelineFood = testFeline.eatMeat();
        String actualFood = String.join(", ", actualFelineFood);

        List<String> expectedFelineFood = List.of("Животные", "Птицы", "Рыба");
        String expectedFood = String.join(", ", expectedFelineFood);

        assertEquals(expectedFood, actualFood);
    }


    @Test
    public void testFoodWithSpy() throws Exception{

        felineSpy.eatMeat();
        Mockito.verify(felineSpy).getFood("Хищник");
    }

    @Test
    public void testFamily() {

        String actualFamily = testFeline.getFamily();
        String expectedFamily = "Кошачьи";
        assertEquals(expectedFamily, actualFamily);
    }
}
