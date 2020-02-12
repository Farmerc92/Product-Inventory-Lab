package models;

public class Soda {
    private String brand;
    private double price;

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
}
