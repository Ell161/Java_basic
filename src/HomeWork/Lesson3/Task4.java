package HomeWork.Lesson3;

import java.util.ArrayList;
import java.util.Random;

// Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
public class Task4 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = createNumbersList(10);
        System.out.println("\nМинимальное значение в списке: " + min(numbers));
        System.out.println("Максимальное значение в списке: " + max(numbers));
        System.out.println("Среднее значение в списке: " + avg(numbers));

    }

    /**
     * @param count Число элементов в массиве
     * @return Список из случайных целочисленных значений в диапазоне от 0 до 100
     */
    public static ArrayList<Integer> createNumbersList(int count) {
        Random random = new Random();
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int number = random.nextInt(100);
            numbers.add(number);
            System.out.print(number + " ");
        }
        return numbers;
    }

    /**
     * @param arrayList Список из целочисленных значений
     * @return Минимальное значение в списке
     */
    public static int min(ArrayList<Integer> arrayList) {
        int min = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (i == 0) min = arrayList.get(i);
            else if (min > arrayList.get(i)) min = arrayList.get(i);
        }
        return min;
    }

    /**
     * @param arrayList Список из целочисленных значений
     * @return Максимальное значение в списке
     */
    public static int max(ArrayList<Integer> arrayList) {
        int max = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (i == 0) max = arrayList.get(i);
            else if (max < arrayList.get(i)) max = arrayList.get(i);
        }
        return max;
    }

    /**
     * @param arrayList Список из целочисленных значений
     * @return Среднее значение в списке
     */
    public static int avg(ArrayList<Integer> arrayList) {
        int avg = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            avg += arrayList.get(i);
        }
        return avg / arrayList.size();
    }
}
