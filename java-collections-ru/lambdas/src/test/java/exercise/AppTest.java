package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


// BEGIN
class AppTest {
    @Test
    void testEnlargeArrayImage() {
        String[][] inputArray = {
                {"*", "*", "*", "*"},
                {"*", " ", " ", "*"},
                {"*", " ", " ", "*"},
                {"*", "*", "*", "*"},
        };
        String[][] expectedOutput = {
                {"*", "*"},
                {"*", "*"},
                {"*", "*"},
                {"*", "*"},
                {"*", "*"},
                {" ", " "},
                {" ", " "},
                {"*", "*"},
                {"*", "*"},
                {" ", " "},
                {" ", " "},
                {"*", "*"},
                {"*", "*"},
                {"*", "*"},
                {"*", "*"},
                {"*", "*"},
        };
        String[][] result = App.enlargeArrayImage(inputArray);
        assertThat(result).isEqualTo(expectedOutput);
    }
    @Test
    void testEnlargeArrayImageZeroElements() {
        String[][] inputArray = {};
        String[][] expectedOutput = {};
        String[][] result = App.enlargeArrayImage(inputArray);
        assertThat(result).isEqualTo(expectedOutput);
    }

}
// END
