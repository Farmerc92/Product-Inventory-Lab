package services;

import models.Soda;
import models.Videogames;

import java.util.ArrayList;

public class VideogamesService {

    private static int nextId = 1;

    private  static ArrayList<Videogames> inventory = new ArrayList<>();


    public Videogames create(String expectedTitle, String expectedGenre, String expectedCondition, String expectedDeveloper, String expectedPublisher, double expectedPrice) {
        Videogames createdVideogames = new Videogames(nextId++, expectedPrice, expectedDeveloper, expectedCondition, expectedPublisher, expectedGenre, expectedTitle);

        inventory.add(createdVideogames);

        return createdVideogames;
    }
}
