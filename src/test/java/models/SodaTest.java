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

}
