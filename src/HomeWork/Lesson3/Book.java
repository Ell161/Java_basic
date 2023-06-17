package HomeWork.Lesson3;

//  Сведения о книге состоят из названия, фамилии автора, цены, года издания и количества страниц.
public class Book {
    private String name;
    private String author;
    private int price;
    private int year;
    private int pages;

    public Book(String name, String author, int price, int year, int pages) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.year = year;
        this.pages = pages;
    }

    public String getValues() {
        return "Book name: " + name + "  |  Author: " + author + "  |  Price: "
                + price + "  |  Publication year: " + year + "  |  Pages: " + pages;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    public int getPages() {
        return pages;
    }

}
