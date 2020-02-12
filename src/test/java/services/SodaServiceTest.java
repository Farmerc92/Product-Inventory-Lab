package services;

import models.Soda;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SodaServiceTest {

    @Test
    public void createTest(){
        String expectedBrand = "Pepsi";
        double expectedPrice = 2.99;

        SodaService  sodaService = new SodaService();
        Soda testSoda = SodaService.create(expectedBrand, expectedPrice);

        int actualId = testSoda.getId();
        String actualBrand = testSoda.getBrand();
        double actualPrice = testSoda.getPrice();

        Assertions.assertEquals(Integer.class.getName(), new Integer(actualId).getClass().getName());
        Assertions.assertEquals(expectedPrice, actualPrice);
        Assertions.assertEquals(expectedBrand, actualBrand);
    }

    @Test
    public void findSneakerTest(){
        String expectedBrand = "Pepsi";
        double expectedPrice = 2.99;

        SodaService  sodaService = new SodaService();
        Soda testSoda = SodaService.create(expectedBrand, expectedPrice);

        String expectedBrand1 = "Coke";
        double expectedPrice1 = 3.99;

        Soda testSoda1 = SodaService.create(expectedBrand1, expectedPrice1);

        Soda expectedSoda = sodaService.findSoda(1);
        Assertions.assertEquals(testSoda, expectedSoda);

        Soda expectedSoda1 = sodaService.findSoda(2);
        Assertions.assertEquals(testSoda1, expectedSoda1);
    }

    @Test
    public void findAllTest(){
        String expectedBrand = "Pepsi";
        double expectedPrice = 2.99;

        SodaService  sodaService = new SodaService();
        Soda testSoda = SodaService.create(expectedBrand, expectedPrice);

        String expectedBrand1 = "Coke";
        double expectedPrice1 = 3.99;

        Soda testSoda1 = SodaService.create(expectedBrand1, expectedPrice1);

        Soda[] sodaArrayExpected = new Soda[2];
        sodaArrayExpected[0] = testSoda;
        sodaArrayExpected[1] = testSoda1;

        Soda[] sodaArrayActual = sodaService.findAll();

        Assertions.assertEquals(sodaArrayExpected[0], sodaArrayActual[0]);
        Assertions.assertEquals(sodaArrayExpected[1], sodaArrayActual[1]);
    }

    @Test
    public void deleteTest(){
        String expectedBrand = "Pepsi";
        double expectedPrice = 2.99;

        SodaService  sodaService = new SodaService();
        Soda testSoda = SodaService.create(expectedBrand, expectedPrice);

        String expectedBrand1 = "Coke";
        double expectedPrice1 = 3.99;

        Soda testSoda1 = SodaService.create(expectedBrand1, expectedPrice1);

        boolean expected = sodaService.delete(1);

        Assertions.assertEquals(expected, true);
        Assertions.assertEquals(sodaService.findSoda(1), null);

    }

}
