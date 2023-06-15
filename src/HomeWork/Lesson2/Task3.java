package HomeWork.Lesson2;

import java.util.Random;
import java.util.Scanner;

// Дан массив целых чисел. Заменить отрицательные элементы на сумму индексов двузначных элементов массива.
public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Количество элементов в массиве: ");
        int numbersCount = sc.nextInt();
        int[] numbersArray = setArray(numbersCount);
        int sunIndexesArray = sumIndexesTwoDigitElements(numbersArray);
        System.out.println("--------------------------------------");
        System.out.println("|                                    |");
        System.out.println("|  your advertisement could be here  |");
        System.out.println("|                                    |");
        System.out.println("--------------------------------------");
        int[] numbersArrayConvert = convertArray(numbersArray, sunIndexesArray);
    }

    /**
     * @param count количество элементов массива
     * @return массив из рандомных целочисленных значений
     * @apiNote Метод задает массив из целых рандомных чисел
     */
    private static int[] setArray(int count) {
        int[] array = new int[count];
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int value = random.nextInt(200) - 100;
            array[i] = value;
            System.out.println(i + ", " + array[i]);
        }
        return array;
    }

    /**
     * @param array массив из целых чисел
     * @return сумма индексов двузначных элементов массива
     * @apiNote Метод возвращает сумму индексов двузначных элементов массива
     */
    private static int sumIndexesTwoDigitElements(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (Math.abs(array[i]) > 9 && Math.abs(array[i]) < 100) sum += i;
        }
        return sum;
    }

    /**
     *
     * @param array массив из целых чисел
     * @param sumIndexes сумма индексов двузначных элементов массива
     * @return Массив из целых чисел, где отрицательные числа заменены на сумму индексов двузначных элементов
     */
    private static int[] convertArray(int[] array, int sumIndexes) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) array[i] = sumIndexes;
            System.out.println(i + ", " + array[i]);
        }
        return array;
    }
}
