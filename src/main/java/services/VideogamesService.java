package services;

import io.Console;
import models.Soda;
import models.Videogames;

import java.util.ArrayList;

public class VideogamesService {

    private static int nextId = 1;

    private  static ArrayList<Videogames> inventory = new ArrayList<>();


    public Videogames create(String expectedTitle, String expectedCondition, double expectedPrice) {
        Videogames createdVideogames = new Videogames(nextId++, expectedPrice, expectedCondition, expectedTitle);

        inventory.add(createdVideogames);

        return createdVideogames;
    }

    public Videogames findVideogames(int id){
        for (Videogames v : inventory){
            if (v.getId()==id){
                return v;
            }
        }
        return null;
    }

    public Videogames[] findAll(){
        Videogames[] videogamesArray = new Videogames[inventory.size()];
        int i = 0;
        while (i < videogamesArray.length){
            videogamesArray[i] = inventory.get(i);
            i++;
        }
        return videogamesArray;
    }

    public boolean delete(int id){
        for (Videogames v : inventory){
            if(v.getId()==id){
                inventory.remove(v);
                return true;
            }
        }
        return false;
    }
}
