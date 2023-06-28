package HomeWork.AttestationWork;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        LaptopList<Laptop> storeLaptops = new LaptopList<>();
        for (int i = 0; i < 20; i++) {
            Laptop laptop = createLaptop();
            storeLaptops.add(laptop);
            System.out.println(laptop.getValues());
            System.out.println();
        }

        ArrayList<String> userFilters = storeLaptops.setFilterList();
        LaptopList<Laptop> filterList = filterLaptopsByParameters(userFilters, storeLaptops);

        for (Laptop laptop : filterList) {
            System.out.println();
            System.out.println(laptop.getValues());
        }
    }

    /**
     * @apiNote Метод возвращает отфильтрованный список по заданным характеристикам
     * @param filters список характеристик для поиска, заданных пользователем
     * @param laptopList список эксземпляров класса Ноутбук
     * @return отфильтрованный список Ноутбуков по заданным характеристикам
     */
    public static LaptopList<Laptop> filterLaptopsByParameters(ArrayList<String> filters, LaptopList<Laptop> laptopList) {
        LaptopList<Laptop> filterLaptopsList = laptopList;
        String message;
        LaptopList<Laptop> temp;
        for (String filter : filters) {
            message = laptopList.messages.get(filter);
            if (filter.equals("maker") ||
                    filter.equals("model") ||
                    filter.equals("processor") ||
                    filter.equals("operationSystem")) {
                Map<String, String> laptopCharacters = laptopList.characters.get(filter);
                ArrayList<String> filterValues = caseStringValue(message, laptopCharacters);
                temp = filterCharacterName(filterLaptopsList, filterValues, filter);
                filterLaptopsList = temp;
            } else if (filter.equals("RAM") ||
                    filter.equals("externalMemory") ||
                    filter.equals("countProductiveCores") ||
                    filter.equals("price") ||
                    filter.equals("quantityInStock") ||
                    filter.equals("discount") ||
                    filter.equals("installmentPayment")) {
                int[] filterIntValues = caseIntValues(message);
                temp = filterIntValue(filterLaptopsList, filterIntValues, filter);
                filterLaptopsList = temp;
            } else if (filter.equals("screenDiagonal")) {
                double[] filterDoubleValues = caseDoubleValues(message);
                temp = filterDoubleValue(filterLaptopsList, filterDoubleValues);
                filterLaptopsList = temp;
            }
        }
        if (filterLaptopsList.isEmpty()) System.out.println("\nПо Вашему запросу товары не найдены.");
        else System.out.println("\nСписок товаров по Вашему запросу:");
        return filterLaptopsList;
    }

    /**
     * @apiNote Метод для инициализации экземпляра класса Ноутбук
     * @return экземпляр класса Ноутбук со случайно сгенерированными параметрами
     */
    public static Laptop createLaptop() {
        String[] makers = new String[]{"ASUS", "Acer ", "Apple", "Dell", "HP", "MSI", "Razer", "Samsung"};
        String[] models = new String[]{"A15644", "M47218", "F00155", "S78075", "L95001"};
        String[] processors = new String[]{"Intel Core i9", "Intel Core i7", "Intel Core i5",
                "AMD Ryzen 9", "AMD Ryzen 7", "AMD Ryzen 5"};
        Integer[] RAMs = new Integer[]{4, 8, 12, 16};
        Integer[] externalMemories = new Integer[]{128, 256, 512, 1000};
        Double[] screenDiagonals = new Double[]{13.9, 14.9, 15.9, 16.0, 17.3};
        String[] operationSystems = new String[]{"Windows", "macOS", "Linux"};
        Integer[] countProductiveCores = new Integer[]{4, 6, 8, 12};

        Random random = new Random();
        int makerIndex = random.nextInt(makers.length);
        String maker = makers[makerIndex];
        int modelIndex = random.nextInt(models.length);
        String model = models[modelIndex];
        int processorIndex = random.nextInt(processors.length);
        String processor = processors[processorIndex];
        int RAMIndex = random.nextInt(RAMs.length);
        int RAM = RAMs[RAMIndex];
        int externalMemoryIndex = random.nextInt(externalMemories.length);
        int externalMemory = externalMemories[externalMemoryIndex];
        int screenDiagonalIndex = random.nextInt(screenDiagonals.length);
        double screenDiagonal = screenDiagonals[screenDiagonalIndex];
        int operationSystemIndex = random.nextInt(operationSystems.length);
        String operationSystem = operationSystems[operationSystemIndex];
        int countProductiveCoresIndex = random.nextInt(countProductiveCores.length);
        int countProductiveCore = countProductiveCores[countProductiveCoresIndex];
        int price = random.nextInt(250000) + 35000;
        int quantityInStock = random.nextInt(10);
        int discount = random.nextInt(10000);
        int installmentPayment = random.nextInt(36) + 6;
        Laptop laptop = new Laptop(maker, model, processor, RAM, externalMemory, screenDiagonal,
                operationSystem, countProductiveCore, price, quantityInStock, discount, installmentPayment);
        return laptop;
    }

    /**
     * @apiNote Метод возвращает список значений для поиска, введенных пользователем, по заданной характеристике
     * @param message сообщение строкового типа, приглашающее пользователя задать параметры поиска
     * @param laptopCharacters характеристика (критерий) класса Ноутбуков для задания поиска
     * @return список значений строкового типа для посика по заданной характеристике
     */
    public static ArrayList<String> caseStringValue(String message, Map<String, String> laptopCharacters) {
        ArrayList<String> stringValuesList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        String[] valueByUser = sc.nextLine().split(" ");
        Set<String> makersSet = Set.of(valueByUser);
        for (String value : makersSet) {
            String forValueList = laptopCharacters.get(value);
            if (forValueList != null) stringValuesList.add(forValueList);
        }
        return stringValuesList;
    }

    /**
     * @apiNote Метод возвращает список значений для поиска, введенных пользователем, по заданной характеристике
     * @param message сообщение строкового типа, приглашающее пользователя задать параметры поиска
     * @return значения целочисленного типа для посика по заданной характеристике
     */
    public static int[] caseIntValues(String message) {
        int[] IntValuesList = new int[]{0, 1000000};
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        String[] valuesByUser = sc.nextLine().split(" ");
        try {
            for (int i = 0; i < 2; i++) {
                try {
                    IntValuesList[i] = Integer.parseInt(valuesByUser[i]);
                } catch (NumberFormatException exception) {
                    return IntValuesList;
                }
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            return IntValuesList;
        }
        return IntValuesList;
    }

    /**
     * @apiNote Метод возвращает список значений для поиска, введенных пользователем, по заданной характеристике
     * @param message сообщение строкового типа, приглашающее пользователя задать параметры поиска
     * @return список значений вещественного типа для посика по заданной характеристике
     */
    public static double[] caseDoubleValues(String message) {
        double[] doubleValuesList = new double[]{0.0, 20.0};
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        String[] valuesByUser = sc.nextLine().split(" ");
        try {
            for (int i = 0; i < 2; i++) {
                try {
                    doubleValuesList[i] = Double.parseDouble(valuesByUser[i]);
                } catch (NumberFormatException exception) {
                    return doubleValuesList;
                }
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            return doubleValuesList;
        }
        return doubleValuesList;
    }

    /**
     * @apiNote Метод возвращает отфильтрованный список по заданным характеристикам
     * @param laptopList список эксземпляров класса Ноутбук
     * @param characterNameList список характеристик Ноутбуков, значения которых представлены строковым типом
     * @param character характеристика (критерий) класса Ноутбуков для задания поиска
     * @return отфильтрованный список Ноутбуков по заданным характеристикам
     */
    public static LaptopList<Laptop> filterCharacterName(LaptopList<Laptop> laptopList,
                                                         ArrayList<String> characterNameList,
                                                         String character) {
        LaptopList<Laptop> filterLaptopList = new LaptopList<>();

        for (String characterName : characterNameList) {
            LaptopList<Laptop> tempFilter;
            switch (character) {
                case "maker":
                    tempFilter = laptopList.stream().filter(laptop ->
                            laptop.getMaker().equals(characterName)).collect(Collectors.toCollection(LaptopList::new));
                    filterLaptopList.addAll(tempFilter);
                case "model":
                    tempFilter = laptopList.stream().filter(laptop ->
                            laptop.getModel().equals(characterName)).collect(Collectors.toCollection(LaptopList::new));
                    filterLaptopList.addAll(tempFilter);
                case "processor":
                    tempFilter = laptopList.stream().filter(laptop ->
                            laptop.getProcessor().equals(characterName)).collect(Collectors.toCollection(LaptopList::new));
                    filterLaptopList.addAll(tempFilter);
                case "operationSystem":
                    tempFilter = laptopList.stream().filter(laptop ->
                            laptop.getOperationSystem().equals(characterName)).collect(Collectors.toCollection(LaptopList::new));
                    filterLaptopList.addAll(tempFilter);
            }
        }
        return filterLaptopList;
    }

    /**
     * @apiNote Метод возвращает отфильтрованный список по заданным характеристикам
     * @param laptopList список эксземпляров класса Ноутбук
     * @param characterValueList список характеристик Ноутбуков, значения которых представлены цулочисленными значениями
     * @param character характеристика (критерий) класса Ноутбуков для задания поиска
     * @return отфильтрованный список Ноутбуков по заданным характеристикам
     */
    public static LaptopList<Laptop> filterIntValue(LaptopList<Laptop> laptopList,
                                                    int[] characterValueList,
                                                    String character) {
        LaptopList<Laptop> filterLaptopList = new LaptopList<>();

        switch (character) {
            case "RAM" -> {
                filterLaptopList = laptopList.stream().filter(laptop ->
                                laptop.getRAM() > characterValueList[0] && laptop.getRAM() < characterValueList[1])
                        .collect(Collectors.toCollection(LaptopList::new));
                return filterLaptopList;
            }
            case "externalMemory" -> {
                filterLaptopList = laptopList.stream().filter(laptop ->
                                laptop.getExternalMemory() > characterValueList[0] && laptop.getExternalMemory() < characterValueList[1])
                        .collect(Collectors.toCollection(LaptopList::new));
                return filterLaptopList;
            }
            case "countProductiveCores" -> {
                filterLaptopList = laptopList.stream().filter(laptop ->
                                laptop.getCountProductiveCores() > characterValueList[0] && laptop.getCountProductiveCores() < characterValueList[1])
                        .collect(Collectors.toCollection(LaptopList::new));
                return filterLaptopList;
            }
            case "price" -> {
                filterLaptopList = laptopList.stream().filter(laptop ->
                                laptop.getPrice() > characterValueList[0] && laptop.getPrice() < characterValueList[1])
                        .collect(Collectors.toCollection(LaptopList::new));
                return filterLaptopList;
            }
            case "quantityInStock" -> {
                filterLaptopList = laptopList.stream().filter(laptop ->
                                laptop.getQuantityInStock() > characterValueList[0] && laptop.getQuantityInStock() < characterValueList[1])
                        .collect(Collectors.toCollection(LaptopList::new));
                return filterLaptopList;
            }
            case "discount" -> {
                filterLaptopList = laptopList.stream().filter(laptop ->
                                laptop.getDiscount() > characterValueList[0] && laptop.getDiscount() < characterValueList[1])
                        .collect(Collectors.toCollection(LaptopList::new));
                return filterLaptopList;
            }
            case "installmentPayment" -> filterLaptopList = laptopList.stream().filter(laptop ->
                            laptop.getInstallmentPaymentMonth() > characterValueList[0] && laptop.getInstallmentPaymentMonth() < characterValueList[1])
                    .collect(Collectors.toCollection(LaptopList::new));
        }
        return filterLaptopList;
    }

    /**
     * @apiNote Метод возвращает отфильтрованный список по заданным характеристикам
     * @param laptopList список эксземпляров класса Ноутбук
     * @param characterValueList список характеристик Ноутбуков, значения которых представлены вещественными значениями
     * @return отфильтрованный список Ноутбуков по заданным характеристикам
     */
    public static LaptopList<Laptop> filterDoubleValue(LaptopList<Laptop> laptopList,
                                                       double[] characterValueList) {
        LaptopList<Laptop> filterLaptopList;
        filterLaptopList = laptopList.stream().filter(laptop ->
                        laptop.getScreenDiagonal() > characterValueList[0] && laptop.getScreenDiagonal() < characterValueList[1])
                .collect(Collectors.toCollection(LaptopList::new));
        return filterLaptopList;
    }
}
