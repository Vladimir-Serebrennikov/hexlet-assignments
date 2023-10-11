package exercise;

import java.util.Map;
import java.util.HashMap;

public class FileKV implements KeyValueStorage {

    private String filePath;
    private Map<String, String> data;

    public FileKV(String filePath, Map<String, String> initialData) {
        this.filePath = filePath;
        this.data = new HashMap<>(initialData);
    }

    @Override
    public void set(String key, String value) {
        data.put(key, value);
        saveDataToFile();
    }

    @Override
    public void unset(String key) {
        data.remove(key);
        saveDataToFile();
    }

    @Override
    public String get(String key, String defaultValue) {
        String value = data.get(key);
        return value != null ? value : defaultValue;
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(data);
    }

    public void saveDataToFile() {
        String serializedData = Utils.serialize(data);
        Utils.writeFile(filePath, serializedData);
    }

    public void loadDataFromFile() {
        String fileContent = Utils.readFile(filePath);
        Map<String, String> deserializedData = Utils.unserialize(fileContent);
        data.clear();
        data.putAll(deserializedData);
    }
}
