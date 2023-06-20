package HomeWork.Lesson4;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        Collections.reverse(numbers);
        System.out.println("Вариант 1:");
        System.out.println(numbers);

        Deque<Integer> numbers2 = new LinkedList<>();
        for (int i = 1; i <= 4; i++) {
            numbers2.add(i);
        }
        System.out.println("Вариант 2:");
        while (numbers2.size() > 0) {
            System.out.print(numbers2.pollLast() + " ");
        }
    }
}
