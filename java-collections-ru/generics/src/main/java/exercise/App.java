package exercise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> criteria) {
        List<Map<String, String>> result = new ArrayList<>();

        for (Map<String, String> book : books) {
            boolean allMatch = true;

            for (Map.Entry<String, String> entry : criteria.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                if (!book.containsKey(key) || !book.get(key).equals(value)) {
                    allMatch = false;
                    break;
                }
            }
            if (allMatch) {
                result.add(book);
            }
        }
        return result;
    }
}
//END
