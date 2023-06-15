package HomeWork.Lesson2;

import java.math.BigInteger;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Количество элементов в массиве: ");
        int numbersCount = sc.nextInt();
        int[] numbersArray = setArray(sc, numbersCount);
        System.out.println("Результат: " + primeNumbersSum(numbersArray));
    }

    /**
     * @apiNote метод, задающий массив из целочисленных значений
     * @param input объект класса Scanner для ввода значений из консоли
     * @param count количество элементов массива, заданное целым положительным числом
     * @return массив целых чисел
     */
    static int[] setArray(Scanner input, int count) {
        int[] array = new int[count];
        System.out.println("Задайте значения массива:");
        for (int i = 0; i < count; i++) {
            System.out.print((i + 1) + " - е ");
            int value = input.nextInt();
            array[i] = value;
        }
        return array;
    }

    /**
     * @apiNote метод для проверки простого числа
     * @param number целое число
     * @return логическое значение проверки метода
     */
    private static boolean checkIsPrime(int number) {
        BigInteger b = new BigInteger(String.valueOf(number));
        return b.isProbablePrime(number);
    }

    /**
     * @apiNote метод для нахождения суммы простых чисел
     * @param array массив из целых чисел
     * @return целочисленное значение суммы
     */
    private static int primeNumbersSum(int[] array) {
        int sum = 0;
        for (int element : array) {
            if (checkIsPrime(element)) sum += element;
        }
        return sum;
    }

}
