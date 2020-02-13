package models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SodaTest {

    @Test
    public void setBrandTest(){
        String expected = "Pepsi";

        Soda testSoda = new Soda();
        testSoda.setBrand(expected);

        Assertions.assertEquals(expected, testSoda.getBrand());
    }

    @Test
    public void setPriceTest(){
        double expected = 2.99;

        Soda testSoda = new Soda();
        testSoda.setPrice(expected);

        Assertions.assertEquals(expected, testSoda.getPrice());
    }

    @Test
    public void constructorTest(){
        int expectedId = 2;
        double expectedPrice = 2.99;
        String expectedBrand = "Pepsi";

        Soda testSoda = new Soda(expectedId, expectedPrice, expectedBrand);

        Assertions.assertEquals(expectedId, testSoda.getId());
        Assertions.assertEquals(expectedPrice, testSoda.getPrice());
        Assertions.assertEquals(expectedBrand, testSoda.getBrand());
    }

    @Test
    public void sodaToStringTest(){
        int expectedId = 2;
        double expectedPrice = 2.99;
        String expectedBrand = "Pepsi";

        Soda testSoda = new Soda(expectedId, expectedPrice, expectedBrand);

        Assertions.assertEquals("The ID is "+ expectedId + ", the price is $" + expectedPrice + ", and the brand is " + expectedBrand + ".", testSoda.toString());
    }

}
