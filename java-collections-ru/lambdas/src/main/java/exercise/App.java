package exercise;

import java.util.Arrays;

public class App {

    public static String[][] enlargeArrayImage(String[][] array) {
        return Arrays.stream(array)
                .flatMap(row -> Arrays.stream(row)
                        .map(cell -> cell + cell)
                )
                .map(cell -> cell.split(""))
                .toArray(String[][]::new);
    }

    public static void main(String[] args) {
        String[][] image = {
                {"*", "*", "*", "*"},
                {"*", " ", " ", "*"},
                {"*", " ", " ", "*"},
                {"*", "*", "*", "*"},
        };
        String[][] enlargedImage = App.enlargeArrayImage(image);
        System.out.println(Arrays.deepToString(enlargedImage));
    }
}
