package com.example;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import static org.junit.Assert.fail;


@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline felineMock = new Feline();

    public LionTest() throws Exception {
    }

    @Test
    public void testLionGetKittens() throws Exception {
        Lion testLion;
        testLion = new Lion("Самец", felineMock);
        testLion.getKittens();
        Mockito.verify(felineMock).getKittens();
    }

    @Test
    public void testLionessGetKittens() throws Exception {
        Lion testLioness;
        testLioness = new Lion("Самка", felineMock);
        testLioness.getKittens();
        Mockito.verify(felineMock).getKittens();
    }

    @Test
    public void testLionFoodMock() throws Exception {
        Lion testLion = new Lion("Самец", felineMock);
        List<String> actualLionFood = testLion.getFood();
        Mockito.verify(felineMock,Mockito.times(1)).getFood("Хищник");

    }

    @Test
    public void testLionessFoodMock() throws Exception {
        Lion testLioness = new Lion("Самка", felineMock);
        List<String> actualLionFood = testLioness.getFood();
        Mockito.verify(felineMock,Mockito.times(1)).getFood("Хищник");

    }
    @Test
    public void testLionSexException() throws Exception {
        String sex = "Львица";
        try { Lion testLion = new Lion(sex, new Feline());
            fail("Should have thrown an exception");}
        catch(Exception exception) {
            String textException = "Используйте допустимые значения пола животного - самец или самка";
            Assert.assertEquals(textException, exception.getMessage());
        }

    }
}

