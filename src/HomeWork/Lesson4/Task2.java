package HomeWork.Lesson4;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите последовательность: ");
        String parenthesis = sc.nextLine();
        System.out.println(checkSequence(parenthesis));

    }

    public static boolean checkSequence(String sequence) {
        Deque<Character> list = new LinkedList<>();
        for (int i = 0; i < sequence.length(); i++) {
            if (sequence.charAt(i) == '(' ||
                    sequence.charAt(i) == '{' ||
                    sequence.charAt(i) == '[')
                list.add(sequence.charAt(i));
            else {
                if (list.isEmpty())
                    return false;
                else if (sequence.charAt(i) == ')' && list.getLast().equals('('))
                    list.pollLast();
                else if (sequence.charAt(i) == '}' && list.getLast().equals('{'))
                    list.pollLast();
                else if (sequence.charAt(i) == ']' && list.getLast().equals('['))
                    list.pollLast();
                else
                    return false;
            }
        }
        return list.isEmpty();
    }
}
