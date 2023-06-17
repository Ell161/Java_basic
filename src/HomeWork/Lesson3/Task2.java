package HomeWork.Lesson3;

import java.util.*;

//  Получить наименования товаров заданного сорта с наименьшей ценой.
public class Task2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Сорт продукта (0 - 4): ");
        int grade = sc.nextInt();

        ArrayList<Product> products = createListProducts(30);
        Map<String, Double> productsByGrade = new HashMap<>();

        for (Product product : products) {
            if (product.getGrade() == grade) {
                if (productsByGrade.isEmpty() || (productsByGrade.get(product.getName()) == null)) {
                    productsByGrade.put(product.getName(), product.getPrice());
                } else {
                    if (productsByGrade.get(product.getName()) > product.getPrice()) {
                        productsByGrade.put(product.getName(), product.getPrice());
                    }
                }
            }
        }

        System.out.println("\nНайденные товары:");

        for (Map.Entry<String, Double> entry : productsByGrade.entrySet())
            System.out.println(entry.getKey() + " = " + entry.getValue());
    }

    /**
     * @return экземпляр класса Product
     * @apiNote Метод генерирует объект класса Product со случайными параметрами
     */
    public static Product createProduct() {
        String[] characters = new String[]{"Высший сорт ", "Премиальный сорт ", "Обычный сорт "};
        String[] names = new String[]{"пшеница", "гречка", "ячмень", "рис"};
        String[] countries = new String[]{"Россия", "Белорусия", "Польша", "Казахстан"};

        Random random = new Random();

        double price = random.nextInt(100) + random.nextDouble();
        double priceRoundOff = (double) Math.round(price * 100) / 100;

        double weight = random.nextInt(1000) + random.nextDouble();
        double weightRoundOff = (double) Math.round(price * 10) / 10;

        int grade = random.nextInt(5);

        int indexCharacters = random.nextInt(characters.length);
        int indexNames = random.nextInt(characters.length);
        int indexCountry = random.nextInt(characters.length);
        String name = characters[indexCharacters] + names[indexNames];
        String country = countries[indexCountry];

        Product product = new Product(name, country, weightRoundOff, priceRoundOff, grade);
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
