package HomeWork.Lesson3;

import java.util.ArrayList;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {

        ArrayList<Product> products = createListProducts(10);
        double maxPrice = 0;
        for (Product product : products) {
            if (product.getName().startsWith("Высший") && (product.getGrade() == 1 || product.getGrade() == 2)) {
                if (maxPrice < product.getPrice()) maxPrice = product.getPrice();
            }
        }
        System.out.println("\nНаибольшая цена товаров: " + maxPrice);
    }

    /**
     * @return экземпляр класса Product
     * @apiNote Метод генерирует объект класса Product со случайными параметрами
     */
    public static Product createProduct() {
        String[] characters = new String[]{"Высший сорт ", "Премиальный сорт ", "Обычный сорт "};
        String[] names = new String[]{"пшеница", "гречка", "ячмень", "рис"};

        Random random = new Random();
        double price = random.nextInt(100) + random.nextDouble();
        double priceRoundOff = (double) Math.round(price * 100) / 100;
        int grade = random.nextInt(5);
        int indexCharacters = random.nextInt(characters.length);
        int indexNames = random.nextInt(characters.length);
        String name = characters[indexCharacters] + names[indexNames];
        Product product = new Product(name, priceRoundOff, grade);
        return product;
    }

    /**
     * @param count Количество элементов в списке
     * @return Список из экземпляров класса Product со случайными значениями
     * @apiNote Метода задает список из экземпляров класса Product со случайными значениями
     */
    public static ArrayList<Product> createListProducts(int count) {
        ArrayList<Product> products = new ArrayList<Product>();
        for (int i = 0; i < count; i++) {
            Product product = createProduct();
            products.add(product);
            System.out.println(product.getValues());
        }
        return products;
    }
}
