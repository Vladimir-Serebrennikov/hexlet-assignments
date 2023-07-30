package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble(String symbols, String word) {
        word = word.toLowerCase();
        char[] array = symbols.toCharArray();
        for (char ch : word.toCharArray()) {
            int index = symbols.indexOf(ch);
            if (index == -1) {
                return false;
            }
            symbols = symbols.substring(0, index) + symbols.substring(index + 1);
        }
        return true;
    }
}
//END
