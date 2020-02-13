package services;

import models.Soda;
import models.Videogames;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VideogamesServiceTest {

    @Test
    public void createTest(){

        String expectedTitle = "Battlefield";
        String expectedCondition = "New";
        double expectedPrice = 59.99;

        VideogamesService videogamesService = new VideogamesService();
        Videogames testVideogames = videogamesService.create(expectedTitle, expectedCondition, expectedPrice);

        int actualId = testVideogames.getId();
        double actualPrice = testVideogames.getPrice();
        String actualTitle = testVideogames.getTitle();
        String actualCondition = testVideogames.getCondition();

        Assertions.assertEquals(Integer.class.getName(), new Integer(actualId).getClass().getName());
        Assertions.assertEquals(expectedTitle, actualTitle);
        Assertions.assertEquals(expectedPrice, actualPrice);
        Assertions.assertEquals(expectedCondition, actualCondition);
    }

    @Test
    public void findVideogamesTest(){
        String expectedTitle = "Battlefield";
        String expectedCondition = "New";
        double expectedPrice = 59.99;

        VideogamesService videogamesService = new VideogamesService();
        Videogames testVideogames = videogamesService.create(expectedTitle, expectedCondition, expectedPrice);

        String expectedTitle1 = "Halo";
        String expectedCondition1 = "New";
        double expectedPrice1 = 59.99;

        Videogames testVideogames1 = videogamesService.create(expectedTitle1, expectedCondition1, expectedPrice1);

        Videogames expectedVideogames = videogamesService.findVideogames(1);
        Assertions.assertEquals(expectedVideogames, testVideogames);

        Videogames expectedVideogames1 = videogamesService.findVideogames(2);
        Assertions.assertEquals(expectedVideogames1, testVideogames1);
    }

    @Test
    public void findAllTest(){
        String expectedTitle = "Battlefield";
        String expectedCondition = "New";
        double expectedPrice = 59.99;

        VideogamesService videogamesService = new VideogamesService();
        Videogames testVideogames = videogamesService.create(expectedTitle, expectedCondition, expectedPrice);

        String expectedTitle1 = "Halo";
        String expectedCondition1 = "New";
        double expectedPrice1 = 59.99;

        Videogames testVideogames1 = videogamesService.create(expectedTitle1, expectedCondition1, expectedPrice1);

        Videogames[] videogamesArrayActual = new Videogames[2];
        videogamesArrayActual[0] = testVideogames;
        videogamesArrayActual[1] = testVideogames1;

        Videogames[] videogamesArrayExpected = videogamesService.findAll();

        Assertions.assertEquals(videogamesArrayExpected[0], videogamesArrayActual[0]);
        Assertions.assertEquals(videogamesArrayExpected[1], videogamesArrayActual[1]);
    }

    @Test
    public void deleteTest(){
        String expectedTitle = "Battlefield";
        String expectedCondition = "New";
        double expectedPrice = 59.99;

        VideogamesService videogamesService = new VideogamesService();
        Videogames testVideogames = videogamesService.create(expectedTitle, expectedCondition, expectedPrice);

        String expectedTitle1 = "Halo";
        String expectedCondition1 = "New";
        double expectedPrice1 = 59.99;

        Videogames testVideogames1 = videogamesService.create(expectedTitle1, expectedCondition1, expectedPrice1);

        boolean expected = videogamesService.delete(1);

        Assertions.assertEquals(expected, true);
        Assertions.assertEquals(videogamesService.findVideogames(1), null);
    }
}
