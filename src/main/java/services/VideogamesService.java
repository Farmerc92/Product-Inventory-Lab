package services;


import models.Videogames;
import utils.CSVUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

    public void loadDataVideoGames(){
        // (1)
        String csvFile = "/Users/cfarmer/Desktop/VideoGames.csv";
        String line = "";
        String csvSplitBy = ",";

        // (2)
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            nextId = Integer.parseInt(br.readLine());  // (3)

            while ((line = br.readLine()) != null) {
                // split line with comma
                String[] beer = line.split(csvSplitBy);

                // (4)
                int id = Integer.parseInt(beer[0]);
                double price = Double.parseDouble(beer[1]);
                String condition = beer[2];
                String title = beer[3];

                // (5)
                inventory.add(new Videogames(id, price, condition, title));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveInventoryVideoGames() throws IOException {
        String csvFile = "/Users/cfarmer/Desktop/VideoGames.csv";
        FileWriter writer = new FileWriter(csvFile); //(1)

        CSVUtils.writeLine(writer, new ArrayList<String>(Arrays.asList(String.valueOf(nextId))));  // (2)

        for (Videogames s : inventory) {
            List<String> list = new ArrayList<>(); // (3)
            list.add(String.valueOf(s.getId()));
            list.add(String.valueOf(s.getPrice()));
            list.add(String.valueOf(s.getCondition()));
            list.add(String.valueOf(s.getTitle()));

            CSVUtils.writeLine(writer, list);  // (4)
        }

// (5)
        writer.flush();
        writer.close();
    }
}
