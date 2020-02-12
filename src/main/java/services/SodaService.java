package services;

import models.Soda;

import java.util.ArrayList;

public class SodaService {
    
    private static int nextId = 1;
    
    private  static ArrayList<Soda> inventory = new ArrayList<>();

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

}
