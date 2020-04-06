package services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import models.Soda;
import utils.CSVUtils;

import java.io.*;
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

    public void loadDataSoda() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        this.inventory = objectMapper.readValue(new File("soda.json"), new TypeReference<ArrayList<Soda>>(){});
    }

    public static void saveInventorySoda() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(new File("/Users/cfarmer/Projects/Product-Inventory-Lab/soda.json"), inventory);
    }

}
