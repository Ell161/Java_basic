package HomeWork.AttestationWork;

import java.util.*;

public class LaptopList<Laptop> extends ArrayList<Laptop> {

    protected Map<String, Map<String, String>> characters = new HashMap<>() {{
        put("maker", new HashMap<>() {{
            put("1", "ASUS");
            put("2", "Acer");
            put("3", "Apple");
            put("4", "Dell");
            put("5", "HP");
            put("6", "MSI");
            put("7", "Razer");
            put("8", "Samsung");
        }});
        put("model", new HashMap<>() {{
            put("1", "A15644");
            put("2", "M47218");
            put("3", "F00155");
            put("4", "S78075");
            put("5", "L95001");
        }});
        put("processor", new HashMap<>() {{
            put("1", "Intel Core i9");
            put("2", "Intel Core i7");
            put("3", "Intel Core i5");
            put("4", "AMD Ryzen 9");
            put("5", "AMD Ryzen 7");
            put("6", "AMD Ryzen 5");
        }});
        put("operationSystem", new HashMap<>() {{
            put("1", "Windows");
            put("2", "macOS");
            put("3", "Linux");
        }});
    }};

    protected Map<String, String> messages = new HashMap<>() {{
        put("maker", "Выберите производителя (значения необходимо вводить через пробел)" +
                "\n________________________________________________________________________________" +
                "\nASUS - 1, Acer - 2, Apple - 3, Dell - 4, HP - 5, MSI - 6, Razer - 7, Samsung - 8");
        put("model", "Выберите модель (значения необходимо вводить через пробел)" +
                "\n________________________________________________________________________________" +
                "\nA15644 - 1, M47218 - 2, F00155 - 3, S78075 - 4, L95001 - 5");
        put("processor", "Выберите процессор (значения необходимо вводить через пробел)" +
                "\n________________________________________________________________________________" +
                "\nIntel Core i9 - 1, Intel Core i7 - 2, Intel Core i5 - 3, " +
                "AMD Ryzen 9 - 4, AMD Ryzen 7 - 5, AMD Ryzen 5 - 6");
        put("operationSystem", "Выберите операционную систему (значения необходимо вводить через пробел)" +
                "\n________________________________________________________________________________" +
                "\nWindows - 1, macOS - 2, Linux - 3, " );
        put("RAM", "Объем опреативной памяти от - до - (значения необходимо вводить через пробел)" +
                "\n________________________________________________________________________________");
        put("externalMemory", "Объем внешней памяти от - до - (значения необходимо вводить через пробел)" +
                "\n________________________________________________________________________________");
        put("countProductiveCores", "Количество производительных ядер от - до - (значения необходимо вводить через пробел)" +
                "\n________________________________________________________________________________");
        put("price", "Цена от - до - (значения необходимо вводить через пробел)" +
                "\n________________________________________________________________________________");
        put("quantityInStock", "В наличии от - до - (значения необходимо вводить через пробел)" +
                "\n________________________________________________________________________________");
        put("discount", "Скидка от - до - (значения необходимо вводить через пробел)" +
                "\n________________________________________________________________________________");
        put("installmentPayment", "Рассрочка от - до - (значения необходимо вводить через пробел)" +
                "\n________________________________________________________________________________");
        put("screenDiagonal", "Диагональ от - до - (значения необходимо вводить через пробел)" +
                "\n________________________________________________________________________________");
    }};

    protected ArrayList<String> setFilterList() {
        ArrayList<String> userFilters = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        Map<String, String> filters = new HashMap<>(Map.ofEntries(
                new AbstractMap.SimpleEntry<String, String>("maker", "Производитель(+/-): "),
                new AbstractMap.SimpleEntry<String, String>("model", "Модель(+/-): "),
                new AbstractMap.SimpleEntry<String, String>("processor", "Процессор(+/-): "),
                new AbstractMap.SimpleEntry<String, String>("RAM", "Объем оперативной памяти(+/-): "),
                new AbstractMap.SimpleEntry<String, String>("externalMemory", "Обем внешней памяти(+/-): "),
                new AbstractMap.SimpleEntry<String, String>("screenDiagonal", "Диагональ(+/-): "),
                new AbstractMap.SimpleEntry<String, String>("operationSystem", "Операционная система(+/-): "),
                new AbstractMap.SimpleEntry<String, String>("countProductiveCores", "Количество производительных ядер(+/-): "),
                new AbstractMap.SimpleEntry<String, String>("price", "Цена(+/-): "),
                new AbstractMap.SimpleEntry<String, String>("quantityInStock", "В наличии(+/-): "),
                new AbstractMap.SimpleEntry<String, String>("discount", "Скида(+/-): "),
                new AbstractMap.SimpleEntry<String, String>("installmentPayment", "Рассрочка(+/-): ")
        ));

        for (Map.Entry<String, String> entry : filters.entrySet()) {
            System.out.println(entry.getValue());
            String input = sc.nextLine();
            if (input.equals("+")) {
                userFilters.add(entry.getKey());
            }
        }
        return userFilters;
    }
}

class LaptopMakerComparator implements Comparator<Laptop> {
    public int compare(Laptop laptop1, Laptop laptop2) {
        return laptop1.getMaker().compareTo(laptop2.getMaker());
    }
}

class LaptopModelComparator implements Comparator<Laptop> {
    public int compare(Laptop laptop1, Laptop laptop2) {
        return laptop1.getModel().compareTo(laptop2.getModel());
    }
}

class LaptopProcessorComparator implements Comparator<Laptop> {
    public int compare(Laptop laptop1, Laptop laptop2) {
        return laptop1.getProcessor().compareTo(laptop2.getProcessor());
    }
}

class LaptopRAMComparator implements Comparator<Laptop> {
    public int compare(Laptop laptop1, Laptop laptop2) {
        return Integer.compare(laptop1.getRAM(), laptop2.getRAM());
    }
}

class LaptopExternalMemoryComparator implements Comparator<Laptop> {
    public int compare(Laptop laptop1, Laptop laptop2) {
        return Integer.compare(laptop1.getExternalMemory(), laptop2.getExternalMemory());
    }
}

class LaptopScreenDiagonalComparator implements Comparator<Laptop> {
    public int compare(Laptop laptop1, Laptop laptop2) {
        return Double.compare(laptop1.getScreenDiagonal(), laptop2.getScreenDiagonal());
    }
}

class LaptopOperationSystemComparator implements Comparator<Laptop> {
    public int compare(Laptop laptop1, Laptop laptop2) {
        return laptop1.getOperationSystem().compareTo(laptop2.getOperationSystem());
    }
}

class LaptopCountProductiveCoresComparator implements Comparator<Laptop> {
    public int compare(Laptop laptop1, Laptop laptop2) {
        return Integer.compare(laptop1.getCountProductiveCores(), laptop2.getCountProductiveCores());
    }
}

class LaptopPriceComparator implements Comparator<Laptop> {
    public int compare(Laptop laptop1, Laptop laptop2) {
        return Integer.compare(laptop1.getPrice(), laptop2.getPrice());
    }
}

class LaptopQuantityInStockComparator implements Comparator<Laptop> {
    public int compare(Laptop laptop1, Laptop laptop2) {
        return Integer.compare(laptop1.getQuantityInStock(), laptop2.getQuantityInStock());
    }
}

class LaptopDiscountComparator implements Comparator<Laptop> {
    public int compare(Laptop laptop1, Laptop laptop2) {
        return Integer.compare(laptop1.getDiscount(), laptop2.getDiscount());
    }
}

class LaptopInstallmentPaymentMonthComparator implements Comparator<Laptop> {
    public int compare(Laptop laptop1, Laptop laptop2) {
        return Integer.compare(laptop1.getInstallmentPaymentMonth(), laptop2.getInstallmentPaymentMonth());
    }
}