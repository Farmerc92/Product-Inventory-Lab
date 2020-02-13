package io;

import java.util.Scanner;

public class Console {
    public static void printWelcome(){
        System.out.println("" +
                "**************************************************\n" +
                "***           Welcome and Bienvenue            ***\n" +
                "***                    to                      ***\n" +
                "***      Chris Farmer's Inventory Manager      ***\n" +
                "**************************************************\n");
    }
    public static  Integer getIntegerInput(String prompt)
    {
        Scanner number = new Scanner(System.in);
        System.out.println(prompt);
        Integer num = number.nextInt();
        return num;
    }
}
