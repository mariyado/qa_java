package com.example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParamTest {

    private final int kittensCount;
    private final int resultKittensCount;

    public FelineParamTest(int kittensCount, int resultKittensCount) {
        this.kittensCount = kittensCount;
        this.resultKittensCount = resultKittensCount;
    }

    @Parameterized.Parameters
    public static Object[][] felineTest() {
        return new Object[][]{
                {1, 1},
                {0, 0},
                {5, 5},
        };
    }

    @Test
    public void testKittens() {
        Feline testFeline = new Feline();
        assertEquals(testFeline.getKittens(kittensCount), resultKittensCount);
    }
}

