package models;

public class Videogames {
    private int id;
    private String title;
    private double price;
    private String condition;

    public Videogames(){}

    public Videogames(int expectedId, double expectedPrice, String expectedCondition, String expectedTitle) {
        id = expectedId;
        price = expectedPrice;
        condition = expectedCondition;
        title = expectedTitle;
    }
    @Override
    public String toString(){
        return "The ID is "+ id + ", the price is $" + price + ", the condition is " + condition + ", and the title is " + title + ".";
    }


    public void setTitle(String expected) {
        title = expected;
    }

    public String getTitle() {
        return title;
    }

    public void setPrice(double expected) {
        price = expected;
    }

    public double getPrice() {
        return price;
    }

    public void setCondition(String expected) {
        condition = expected;
    }

    public String getCondition() {
        return condition;
    }

    public void setId(int expected){
        id = expected;
    }

    public int getId(){
        return id;
    }
}
