package application;
import java.util.Scanner;
import io.Console;
import services.SodaService;
import services.VideogamesService;

public class App {

    private VideogamesService videogamesService = new VideogamesService();
    private SodaService sodaService = new SodaService();

    public static void main(String... args){
        App application = new App();
        application.init();
    }

    public void init(){
        Console.printWelcome();
        do {
            try {
                Integer selection = Console.getIntegerInput("Here is what you can do... Create different Videogames(1) or Soda(2), read from existing products(3), " + "\n" +
                                                                    "update products(4), delete products(5), get different products(6), and exit(7).");
                //beError = false;
                switch (selection){
                    case 1:
                        System.out.println("yay");
                        break;
                    case 2:
                        System.out.println("nay");
                        break;
                    case 3:
                        System.out.println("nay");
                        break;
                    case 4:
                        System.out.println("nay");
                        break;
                    case 5:
                        System.out.println("nay");
                        break;
                    case 6:
                        System.out.println("nay");
                        break;
                    case 7:
                        System.exit(0);
                        break;
                }

            } catch (Exception e){
                System.out.println("Invalid entry.  Try again.");
            }
        } while (true);
    }
}
