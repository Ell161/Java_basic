package HomeWork.Lesson2;

import java.util.Scanner;
import static HomeWork.Lesson2.Task1.setArray;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Количество элементов в массиве: ");
        int numbersCount = sc.nextInt();
        int[] numbersArray = setArray(sc, numbersCount);
        if (isGrowing(numbersArray)) System.out.println("Последовательность возрастающая");
        else System.out.println("Последовательность не возрастающая");
    }

    /**
     * @apiNote Метод, определяющий, что последовательность возрастающая
     * @param array массив из целых чисел
     * @return логическое значение проверки метода
     */
    private static boolean isGrowing(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
