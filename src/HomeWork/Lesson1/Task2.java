package HomeWork.Lesson1;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int sum = 0;
        while (num != 0) {
            int temp = sc.nextInt();
            if (temp < 0 && num > 0) {
                sum += num;
            }
            num = temp;
        }
        System.out.println("Результат: " + sum);
    }

}
