package services;

import models.Videogames;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VideogamesServiceTest {

    @Test
    public void createTest(){

        String expectedTitle = "Battlefield";
        String expectedDeveloper = "Dice";
        String expectedPublisher = "EA";
        String expectedCondition = "New";
        String expectedGenre = "Shooter";
        double expectedPrice = 59.99;

        VideogamesService videogamesService = new VideogamesService();
        Videogames testVideogames = videogamesService.create(expectedTitle, expectedGenre, expectedCondition,expectedDeveloper,expectedPublisher,expectedPrice);

        int actualId = testVideogames.getId();
        double actualPrice = testVideogames.getPrice();
        String actualTitle = testVideogames.getTitle();
        String actualDeveloper = testVideogames.getDeveloper();
        String actualPublisher = testVideogames.getPublisher();
        String actualCondition = testVideogames.getCondition();
        String actualGenre = testVideogames.getGenre();

        Assertions.assertEquals(Integer.class.getName(), new Integer(actualId).getClass().getName());
        Assertions.assertEquals(expectedTitle, actualTitle);
        Assertions.assertEquals(expectedPrice, actualPrice);
        Assertions.assertEquals(expectedCondition, actualCondition);
        Assertions.assertEquals(expectedDeveloper, actualDeveloper);
        Assertions.assertEquals(expectedGenre, actualGenre);
        Assertions.assertEquals(expectedPublisher, actualPublisher);


    }
}
