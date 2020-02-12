package models;

public class Videogames {
    private int id;
    private String title;
    private String developer;
    private String genre;
    private String publisher;
    private double price;
    private String condition;

    public Videogames(){}

    public Videogames(int expectedId, double expectedPrice, String expectedDeveloper, String expectedCondition, String expectedPublisher, String expectedGenre, String expectedTitle) {
        id = expectedId;
        price = expectedPrice;
        developer = expectedDeveloper;
        condition = expectedCondition;
        publisher = expectedPublisher;
        genre = expectedGenre;
        title = expectedTitle;
    }


    public void setTitle(String expected) {
        title = expected;
    }

    public String getTitle() {
        return title;
    }

    public void setDeveloper(String expected) {
        developer = expected;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setGenre(String expected) {
        genre = expected;
    }

    public String getGenre() {
        return genre;
    }

    public void setPublisher(String expected) {
        publisher = expected;
    }

    public String getPublisher() {
        return publisher;
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
