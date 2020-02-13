package models;

public class Soda {
    private int id;
    private String brand;
    private double price;

    public Soda(){}

    public Soda(int expectedId, double expectedPrice, String expectedBrand) {
        id = expectedId;
        brand = expectedBrand;
        price = expectedPrice;
    }

    @Override
    public String toString(){
        return "The ID is "+ id + ", the price is $" + price + ", and the brand is " + brand + ".";
    }

    public void setBrand(String expected) {
        brand = expected;
    }

    public String getBrand() {
        return brand;
    }

    public void setPrice(double expected) {
        price = expected;
    }

    public double getPrice() {
        return price;
    }

    public void setId(int expected){
        id = expected;
    }

    public int getId(){
        return id;
    }

}
