package services;

import models.Soda;
import utils.CSVUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SodaService {
    
    private static int nextId = 1;
    
    private static ArrayList<Soda> inventory = new ArrayList<>();

    public static Soda create(String expectedBrand, double expectedPrice) {
        Soda createdSoda = new Soda(nextId++, expectedPrice, expectedBrand);
        inventory.add(createdSoda);
        return createdSoda;
    }

    public Soda findSoda (int id){
        for (Soda s : inventory){
            if (s.getId()==id){
                return s;
            }
        }
        return null;
    }

    public Soda[] findAll(){
        Soda[] sodaArray = new Soda[inventory.size()];
        int i = 0;
        while (i < sodaArray.length){
            sodaArray[i] = inventory.get(i);
            i++;
        }
        return sodaArray;
    }

    public boolean delete(int id) {
        for (Soda s : inventory){
            if(s.getId()==id){
                inventory.remove(s);
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Soda> getInventory(){
        return inventory;
    }
    public void loadDataSoda(){
        // (1)
        String csvFile = "/Users/cfarmer/Desktop/Soda.csv";
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
                String brand = beer[1];
                double price = Double.parseDouble(beer[2]);

                // (5)
                inventory.add(new Soda(id, price, brand));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveInventorySoda() throws IOException {
        String csvFile = "/Users/cfarmer/Desktop/Soda.csv";
        FileWriter writer = new FileWriter(csvFile); //(1)

        CSVUtils.writeLine(writer, new ArrayList<String>(Arrays.asList(String.valueOf(nextId))));  // (2)

        for (Soda s : inventory) {
            List<String> list = new ArrayList<>(); // (3)
            list.add(String.valueOf(s.getId()));
            list.add(s.getBrand());
            list.add(String.valueOf(s.getPrice()));

            CSVUtils.writeLine(writer, list);  // (4)
        }
        writer.flush();
        writer.close();
    }

}
