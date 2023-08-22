    package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.stream.Collectors;

// BEGIN
    public class App {

        public static Map<String, String> genDiff(Map<String, ?> map1, Map<String, ?> map2) {
            Map<String, String> diff = new LinkedHashMap<>();

            // Find deleted keys
            map1.keySet().stream()
                    .filter(key -> !map2.containsKey(key))
                    .forEach(key -> diff.put(key, "deleted"));

            // Find added keys
            map2.keySet().stream()
                    .filter(key -> !map1.containsKey(key))
                    .forEach(key -> diff.put(key, "added"));

            // Find changed or unchanged keys
            map1.keySet().stream()
                    .filter(key -> map2.containsKey(key))
                    .forEach(key -> {
                        if (map1.get(key).equals(map2.get(key))) {
                            diff.put(key, "unchanged");
                        } else {
                            diff.put(key, "changed");
                        }
                    });

            return diff.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        }

        public static void main(String[] args) {
            Map<String, Object> data1 = new HashMap<>(
                    Map.of("two", "own", "one", "one")
            );
            Map<String, Object> data2 = new HashMap<>(
                    Map.of("one", "eon", "two", "two")
            );

            Map<String, String> result = App.genDiff(data1, data2);
            System.out.println(result); //=> {four=unchanged, one=deleted, two=changed, zero=added}

        }
    }



//END
