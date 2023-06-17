package HomeWork.Lesson3;

import java.util.ArrayList;

public class Product {
    private String name;
    private String country;
    private double weight;
    private double price;
    private int grade;

    public Product(String name, double price, int grade) {
        this.name = name;
        this.country = null;
        this.weight = 0;
        this.price = price;
        this.grade = grade;
    }

    public Product(String name, String country, double weight, double price, int grade) {
        this.name = name;
        this.country = country;
        this.weight = weight;
        this.price = price;
        this.grade = grade;
    }

    public String getValues() {
        return "Product name: " + name + "  |  Country: " + country + "  |  Weight: "
                + weight + "  |  Price: " + price + "  |  Grade: " + grade;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getGrade() {
        return grade;
    }

}
