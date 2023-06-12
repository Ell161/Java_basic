package HomeWork.Lesson1;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String[] words = str.split(" ");
        if (words.length > 1) {
            String reverseWords = reverse(words);
            System.out.println("Результат: " + reverseWords);
        } else {
            System.out.println("Введено всего 1 слово: " + str);
        }
    }

    /**
     * @param array массив из строковых значений
     * @return строка значений массива в обратном порядке
     * @apiNote Возвращает строку слов в обратном порядке, объединенных одним пробелом.
     */
    private static String reverse(String[] array) {
        String[] newArray = new String[array.length];

        for (int i = 0; i < array.length; i++) {
            newArray[array.length - 1 - i] = array[i];
        }
        String reverseArray = String.join(" ", newArray);

        return reverseArray;
    }
}
