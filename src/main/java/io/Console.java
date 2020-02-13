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

    public static String getStringInput(String prompt)
    {
        Scanner string = new Scanner(System.in);
        System.out.println(prompt);
        String str = string.nextLine();
        return str;
    }

    public static Double getDoubleInput(String prompt) {
        Scanner doubl = new Scanner(System.in);
        System.out.println(prompt);
        Double dou = doubl.nextDouble();
        return dou;
    }
}
