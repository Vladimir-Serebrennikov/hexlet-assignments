package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
class App {
    public static long getCountOfFreeEmails(List<String> list) {
        long gmail = list.stream()
                .filter(email -> email.endsWith("gmail.com"))
                .count();
        long yandex = list.stream()
                .filter(email -> email.endsWith("yandex.ru"))
                .count();
        long hotmail = list.stream()
                .filter(email -> email.endsWith("hotmail.com"))
                .count();
        return gmail + yandex + hotmail;
    }
}
// END
