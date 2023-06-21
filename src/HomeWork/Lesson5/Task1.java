package HomeWork.Lesson5;

import java.util.HashMap;
import java.util.Map;

// Подсчитать количество искомого слова, через map (наполнением значение,
// где искомое слово будет являться ключом), вносить все слова не нужно.
public class Task1 {
    public static void main(String[] args) {
        String phrase = "Россия идет вперед всей планеты. Планета — это не Россия.";
        Map<String, Integer> wordCount = new HashMap<>();
        String[] words = phrase.split("\\P{L}+");
        String findWord = "Россия";
        String findWordLower = findWord.toLowerCase();

        for (String word : words) {
            String lowerS = word.toLowerCase();
            if (lowerS.equals(findWordLower)) {
                if (wordCount.containsKey(findWord)) wordCount.put(findWord, wordCount.get(findWord) + 1);
                else wordCount.put(findWord, 1);
            }

        }
        System.out.println(wordCount);
    }
}
