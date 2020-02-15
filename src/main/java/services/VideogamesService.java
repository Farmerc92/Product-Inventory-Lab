package services;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import models.Soda;
import models.Videogames;
import utils.CSVUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public static ArrayList<Videogames> getInventory(){
        return inventory;
    }

    public void loadDataVideoGames() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        this.inventory = objectMapper.readValue(new File("/Users/cfarmer/Projects/Product-Inventory-Lab/videogames.json"), new TypeReference<ArrayList<Videogames>>(){});
    }

    public static void saveInventoryVideoGames() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(new File("/Users/cfarmer/Projects/Product-Inventory-Lab/videogames.json"), inventory);
    }
}
