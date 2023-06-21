package HomeWork.Lesson5;

import java.util.HashMap;
import java.util.Map;

// Подсчитать количество вхождения каждого слова.
public class Task2 {
    public static void main(String[] args) {
        String phrase = "Россия идет вперед всей планеты. Планета — это не Россия.";
        Map<String, Integer> wordCount = new HashMap<>();
        String[] words = phrase.split("\\P{L}+");

        for (String word : words) {
            String lowerS = word.toLowerCase();
            if (wordCount.containsKey(lowerS)) wordCount.put(lowerS, wordCount.get(lowerS) + 1);
            else wordCount.put(lowerS, 1);
        }
        System.out.println(wordCount);
    }
}
