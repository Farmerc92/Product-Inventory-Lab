package models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VideogamesTest {

    @Test
    public void setTitleTest(){
        String expected = "Monster Hunter: World";

        Videogames testVideogames = new Videogames();
        testVideogames.setTitle(expected);

        Assertions.assertEquals(expected, testVideogames.getTitle());
    }

    @Test
    public void setConditionTest(){
        String expected = "Used";

        Videogames testVideogames = new Videogames();
        testVideogames.setCondition(expected);

        Assertions.assertEquals(expected, testVideogames.getCondition());
    }

    @Test
    public void setPriceTest(){
        double expected = 59.99;

        Videogames testVideogames = new Videogames();
        testVideogames.setPrice(expected);

        Assertions.assertEquals(expected, testVideogames.getPrice());
    }
    @Test
    public void setIdTest(){
        int expected = 2;

        Videogames testVideogames = new Videogames();
        testVideogames.setId(expected);

        Assertions.assertEquals(expected, testVideogames.getId());
    }

    @Test
    public void constructorTest(){
        double expectedPrice = 59.99;
        int expectedId = 2;
        String expectedCondition = "Used";
        String expectedTitle = "Battlefield";

        Videogames testVideogames = new Videogames(expectedId, expectedPrice, expectedCondition, expectedTitle);

        Assertions.assertEquals(expectedId, testVideogames.getId());
        Assertions.assertEquals(expectedPrice, testVideogames.getPrice());
        Assertions.assertEquals(expectedTitle, testVideogames.getTitle());
        Assertions.assertEquals(expectedCondition, testVideogames.getCondition());
    }



}
