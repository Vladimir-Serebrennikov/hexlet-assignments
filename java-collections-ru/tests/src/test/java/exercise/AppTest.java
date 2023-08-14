package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {
    // BEGIN
    @Test
    void testTake() {

        List<Integer> inputList = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> expectedOutput = Arrays.asList(1, 2, 3);
        List<Integer> result = App.take(inputList, 3);
        assertEquals(expectedOutput, result);

    }
    @Test
    void testWrong1() {
        List<Integer> inputList = new ArrayList<>();
        List<Integer> result = App.take(inputList, 3);
        assertEquals(0,result.size());
    }
    @Test
    void testWrong2() {
        List<Integer> inputList = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> result = App.take(inputList, 8);
        assertEquals(inputList, result);
    }// END
}
