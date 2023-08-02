package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        String[] words = sentence.split(" ");
        Map<String, Integer> wordCountMap = new HashMap<>();

        if (sentence.equals("")) {
            wordCountMap.clear();
        }else {
            for (String word : words) {
                word = word.toLowerCase();
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }
        return wordCountMap;
    }

    public static String toString(Map<String, Integer> wordCountMap) {
        StringBuilder result = new StringBuilder("{");
        if (wordCountMap.isEmpty()) {
            result.append("}");
        } else {
            result.append("\n");
            for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
                result.append("  ")
                        .append(entry.getKey())
                        .append(": ")
                        .append(entry.getValue())
                        .append("\n");

        }
            result.append("}");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String sentence = "the java is the best programming language java";
        Map wordsCount = App.getWordCount(sentence);
        String result = App.toString(wordsCount);
        System.out.println(result);
    }


}
//END
