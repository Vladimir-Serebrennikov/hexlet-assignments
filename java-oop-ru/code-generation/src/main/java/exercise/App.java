package exercise;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

// BEGIN
public class App {
    public static void save(Path path, Car car) throws Exception {
        try {
            String carJson = car.serialize();
            Files.writeString(path, carJson, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static Car extract(Path path) {
        String jsonFile = App.readFile(path);
        Car car = Car.unserialize(jsonFile);
        return car;
    }

    public static String readFile(Path filePath) {
        try {
            List<String> lines = Files.readAllLines(filePath);
            String fileContent = String.join(System.lineSeparator(), lines);
            return fileContent;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
// END
