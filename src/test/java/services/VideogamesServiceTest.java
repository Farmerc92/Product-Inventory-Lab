package services;

import models.Soda;
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

    @Test
    public void findVideogamesTest(){
        String expectedTitle = "Battlefield";
        String expectedDeveloper = "Dice";
        String expectedPublisher = "EA";
        String expectedCondition = "New";
        String expectedGenre = "Shooter";
        double expectedPrice = 59.99;

        VideogamesService videogamesService = new VideogamesService();
        Videogames testVideogames = videogamesService.create(expectedTitle, expectedGenre, expectedCondition,expectedDeveloper,expectedPublisher,expectedPrice);

        String expectedTitle1 = "Halo";
        String expectedDeveloper1 = "343";
        String expectedPublisher1 = "Microsoft";
        String expectedCondition1 = "New";
        String expectedGenre1 = "Shooter";
        double expectedPrice1 = 59.99;

        Videogames testVideogames1 = videogamesService.create(expectedTitle1, expectedGenre1, expectedCondition1,expectedDeveloper1,expectedPublisher1,expectedPrice1);

        Videogames expectedVideogames = videogamesService.findVideogames(1);
        Assertions.assertEquals(expectedVideogames, testVideogames);

        Videogames expectedVideogames1 = videogamesService.findVideogames(2);
        Assertions.assertEquals(expectedVideogames1, testVideogames1);
    }

    @Test
    public void findAllTest(){
        String expectedTitle = "Battlefield";
        String expectedDeveloper = "Dice";
        String expectedPublisher = "EA";
        String expectedCondition = "New";
        String expectedGenre = "Shooter";
        double expectedPrice = 59.99;

        VideogamesService videogamesService = new VideogamesService();
        Videogames testVideogames = videogamesService.create(expectedTitle, expectedGenre, expectedCondition,expectedDeveloper,expectedPublisher,expectedPrice);

        String expectedTitle1 = "Halo";
        String expectedDeveloper1 = "343";
        String expectedPublisher1 = "Microsoft";
        String expectedCondition1 = "New";
        String expectedGenre1 = "Shooter";
        double expectedPrice1 = 59.99;

        Videogames testVideogames1 = videogamesService.create(expectedTitle1, expectedGenre1, expectedCondition1,expectedDeveloper1,expectedPublisher1,expectedPrice1);

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
        String expectedDeveloper = "Dice";
        String expectedPublisher = "EA";
        String expectedCondition = "New";
        String expectedGenre = "Shooter";
        double expectedPrice = 59.99;

        VideogamesService videogamesService = new VideogamesService();
        Videogames testVideogames = videogamesService.create(expectedTitle, expectedGenre, expectedCondition,expectedDeveloper,expectedPublisher,expectedPrice);

        String expectedTitle1 = "Halo";
        String expectedDeveloper1 = "343";
        String expectedPublisher1 = "Microsoft";
        String expectedCondition1 = "New";
        String expectedGenre1 = "Shooter";
        double expectedPrice1 = 59.99;

        Videogames testVideogames1 = videogamesService.create(expectedTitle1, expectedGenre1, expectedCondition1,expectedDeveloper1,expectedPublisher1,expectedPrice1);

        boolean expected = videogamesService.delete(1);

        Assertions.assertEquals(expected, true);
        Assertions.assertEquals(videogamesService.findVideogames(1), null);
    }
}
