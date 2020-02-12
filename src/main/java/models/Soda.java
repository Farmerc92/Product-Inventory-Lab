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
