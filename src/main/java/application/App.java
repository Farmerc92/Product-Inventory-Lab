package application;

import io.Console;
import models.Soda;
import models.Videogames;
import services.SodaService;
import services.VideogamesService;

import java.io.IOException;

import static services.SodaService.saveInventorySoda;
import static services.VideogamesService.saveInventoryVideoGames;

public class App {

    private VideogamesService videogamesService = new VideogamesService();
    private SodaService sodaService = new SodaService();

    public static void main(String... args) {
        App application = new App();
        application.init();
    }

    public void init() {
        Console.printWelcome();
        sodaService.loadDataSoda();
        videogamesService.loadDataVideoGames();
        do {
            try {
                Integer selection = Console.getIntegerInput("Here is what you can do... Create different Video games(1) or Soda(2), read from existing products(3), " + "\n" +
                                                                    "update products(4), delete products(5), get different reports about products(6), and exit(7).");
                switch (selection){
                    case 1:
                        do {
                            try {
                                Double createVideogamesPrice = Console.getDoubleInput("Enter a price for a video game.");
                                String createVideogamesTitle = Console.getStringInput("Enter a title.");
                                String createVideogamesCondition = Console.getStringInput("Enter a condition (used or new).");
                                System.out.println(videogamesService.create(createVideogamesTitle, createVideogamesCondition, createVideogamesPrice).toString() + "\n");
                                break;
                            } catch (Exception e){
                                System.out.println("Invalid entry. Try again.");
                            }
                        } while (true);
                        break;
                    case 2:
                        do {
                            try {
                                Double createSodaPrice = Console.getDoubleInput("Enter a price for a soda.");
                                String createSodaBrand = Console.getStringInput("Enter a brand name for soda.");
                                System.out.println(sodaService.create(createSodaBrand, createSodaPrice).toString() + "\n");
                                break;
                            }catch (Exception e){
                                System.out.println("Invalid entry. Try again.");
                            }
                        } while (true);
                        break;
                    case 3:
                        do{
                            try{
                                int SodaOrVideoGames = Console.getIntegerInput("Enter 1 for Soda product list or 2 for Video Games product list");
                                if (SodaOrVideoGames == 1) {
                                    Soda[] allSoda = sodaService.findAll();
                                    for(Soda s : allSoda){
                                        System.out.println(s);
                                    }
                                }
                                else if (SodaOrVideoGames == 2){
                                    Videogames[] allVideogames = videogamesService.findAll();
                                    for(Videogames vg : allVideogames){
                                        System.out.println(vg);
                                    }
                                }
                                else {
                                    System.out.println("Invalid entry. Try again.");
                                }
                                System.out.println("\n");
                                break;
                            }catch (Exception e){
                                System.out.println("Invalid entry. Try again.");
                            }
                        }while (true);
                        break;
                    case 4:
                        do {
                            try {
                                int SodaOrVideoGames = Console.getIntegerInput("Enter 1 to update a Soda product given ID or 2 to update a Video game product give an ID");
                                if (SodaOrVideoGames == 1) {
                                    int whichSodaID = Console.getIntegerInput("Enter an integer for ID.");
                                    Soda sodaPick = sodaService.findSoda(whichSodaID);
                                    int whichSodaField = Console.getIntegerInput("Press 1 to update brand and 2 to update price.");
                                    if (whichSodaField == 1) {
                                        String newBrand = Console.getStringInput("Enter new brand for soda ID "+ sodaPick);
                                        sodaPick.setBrand(newBrand);
                                    }
                                    else if (whichSodaField == 2) {
                                        double newPrice = Console.getDoubleInput("Enter new price for soda ID " + sodaPick);
                                        sodaPick.setPrice(newPrice);
                                    }
                                }
                                else if (SodaOrVideoGames == 2){
                                    int whichVideogamesID = Console.getIntegerInput("Enter an integer for ID");
                                    Videogames videogamePick = videogamesService.findVideogames(whichVideogamesID);
                                    int whichVideogameField = Console.getIntegerInput("Press 1 to update title, 2 to update price, or 3 to update condition.");
                                    if (whichVideogameField == 1) {
                                        String newTitle = Console.getStringInput("Enter new title for videogame ID "+ videogamePick);
                                        videogamePick.setTitle(newTitle);
                                    }
                                    else if (whichVideogameField == 2) {
                                        double newPrice = Console.getDoubleInput("Enter new price for video game ID " + videogamePick);
                                        videogamePick.setPrice(newPrice);
                                    }
                                    else if (whichVideogameField == 3) {
                                        String newCondition = Console.getStringInput("Enter new condition for videogame ID " + videogamePick);
                                        videogamePick.setCondition(newCondition);
                                    }
                                    else {
                                        System.out.println("Invalid entry. Try again.");
                                    }
                                    break;
                                }
                            } catch (Exception e) {
                                System.out.println("Invalid entry. Try again.");
                            }
                        } while (true);
                        break;
                    case 5:
                        do {
                            try {
                                int whichProduct = Console.getIntegerInput("Enter either 1 to delete a video game product with an ID or 2 to delete a soda product with an ID.");
                                if (whichProduct == 1) {
                                    int whichVideogame = Console.getIntegerInput("Enter an ID to delete that video game product.");
                                    if (videogamesService.delete(whichVideogame)) {
                                        System.out.println("The video game product with the ID " + whichVideogame + " has been deleted.");
                                    }
                                    else {
                                        System.out.println("A video game with the product ID "+whichVideogame+" does not exist.");
                                    }
                                }
                                else if (whichProduct == 2){
                                    int whichSoda = Console.getIntegerInput("Enter an ID to delete that soda product.");
                                    if (sodaService.delete(whichSoda)) {
                                        System.out.println("The soda product with the ID " + whichSoda + " has been deleted.");
                                    }
                                    else {
                                        System.out.println("A soda with the product ID "+whichSoda+" does not exist.");
                                    }
                                }
                                else {
                                    System.out.println("Invalid entry. Try again.");
                                }
                                break;
                            } catch (Exception e){
                                System.out.println("Invalid entry. Try again.");
                            }
                        } while (true);
                    case 6:
                        do {
                            try {
                                int whichProduct = Console.getIntegerInput("Enter either 1 to get different reports about video game products or 2 to get different reports about soda products.");
                                if (whichProduct == 1){
                                    int videogamesReportsID = Console.getIntegerInput("Enter an integer to choose ID of video game you wish to see report of.");
                                    int videogamesReports = Console.getIntegerInput("Enter 1 for price, 2 for condition, or 3 for title.");
                                    if (videogamesReports == 1){
                                        System.out.println(videogamesService.findVideogames(videogamesReportsID).getPrice());
                                    }
                                    else if (videogamesReports == 2) {
                                        System.out.println(videogamesService.findVideogames(videogamesReportsID).getCondition());
                                    }
                                    else if (videogamesReports == 3) {
                                        System.out.println(videogamesService.findVideogames(videogamesReportsID).getTitle());
                                    }
                                    else {
                                        System.out.println("Invalid entry. Try again.");
                                    }
                                }
                                else if (whichProduct == 2){
                                    int sodaReportsID = Console.getIntegerInput("Enter an integer to choose ID of soda you wish to see report of.");
                                    int sodaReports = Console.getIntegerInput("Enter 1 for price or 2 for brand.");
                                    if (sodaReports == 1){
                                        System.out.println(sodaService.findSoda(sodaReportsID).getPrice());
                                    }
                                    else if (sodaReports == 2) {
                                        System.out.println(sodaService.findSoda(sodaReportsID).getBrand());
                                    }
                                    else {
                                        System.out.println("Invalid entry. Try again.");
                                    }
                                }
                                else {
                                    System.out.println("Invalid entry. Try again.");
                                }
                                break;
                            } catch (Exception e) {
                                System.out.println("Invalid entry. Try again.");
                            }
                        }while(true);
                    case 7:
                        saveInventorySoda();
                        saveInventoryVideoGames();
                        System.exit(0);
                }
            } catch (Exception e){
                System.out.println("Invalid entry.  Try again.");
            }
        } while (true);
    }
}
