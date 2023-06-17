package HomeWork.Lesson3;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

// Найти названия книг, в которых простое количество страниц,
// фамилия автора содержит «А» и год издания после 2010 г, включительно.
public class Task3 {
    public static void main(String[] args) {
        ArrayList<Book> books = createListBook(20);
        ArrayList<String> bookNames = new ArrayList<>();
        for (Book book : books) {
            if (checkIsPrime(book.getPages())
                    && (book.getYear() >= 2010)
                    && book.getName().toLowerCase().contains("а")) {
                bookNames.add(book.getName());
            }
        }

        System.out.println("\nНайдены книги:");
        for (String book : bookNames) {
            System.out.println(book);
        }
    }

    /**
     * @param number целое число
     * @return логическое значение проверки метода
     * @apiNote метод для проверки простого числа
     */
    private static boolean checkIsPrime(int number) {
        BigInteger b = new BigInteger(String.valueOf(number));
        return b.isProbablePrime(number);
    }

    /**
     * @return экземпляр класса Book
     * @apiNote Метод генерирует объект класса Book со случайными параметрами
     */
    public static Book createBook() {
        String[] books = new String[]{"Тени нашего прошлого", "Непосредственный человек", "Исключительные",
                "Список ненависти", "Лето на Парк-Авеню", "Весь мир Фрэнка Ли", "Обманщик", "Женщина – не мужчина"};
        String[] authors = new String[]{"Гришковец", "Айтматов", "Токарева", "Соболев", "Данилов"};

        Random random = new Random();

        int price = random.nextInt(100);
        int year = random.nextInt(23) + 2000;
        int pages = random.nextInt(15);
        int indexBooks = random.nextInt(books.length);
        int indexAuthor = random.nextInt(authors.length);
        String name = books[indexBooks];
        String author = authors[indexAuthor];

        Book book = new Book(name, author, price, year, pages);
        return book;
    }

    /**
     * @param count Количество элементов в списке
     * @return Список из экземпляров класса Book со случайными значениями
     * @apiNote Метода задает список из экземпляров класса Book со случайными значениями
     */
    public static ArrayList<Book> createListBook(int count) {
        ArrayList<Book> books = new ArrayList<Book>();
        for (int i = 0; i < count; i++) {
            Book book = createBook();
            books.add(book);
            System.out.println(book.getValues());
        }
        return books;
    }
}
