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
    public void setDeveloperTest(){
        String expected = "Dice";

        Videogames testVideogames = new Videogames();
        testVideogames.setDeveloper(expected);

        Assertions.assertEquals(expected, testVideogames.getDeveloper());
    }

    @Test
    public void setGenreTest(){
        String expected = "Shooter";

        Videogames testVideogames = new Videogames();
        testVideogames.setGenre(expected);

        Assertions.assertEquals(expected, testVideogames.getGenre());
    }

    @Test
    public void setPublisherTest(){
        String expected = "EA";

        Videogames testVideogames = new Videogames();
        testVideogames.setPublisher(expected);

        Assertions.assertEquals(expected, testVideogames.getPublisher());
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





}
