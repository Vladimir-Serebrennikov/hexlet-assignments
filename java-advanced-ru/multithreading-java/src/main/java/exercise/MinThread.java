package exercise;

import java.lang.Thread;

// BEGIN
public class MinThread extends Thread {
    private int[] array;
    public MinThread(int[] array) {
        this.array = array;
    }
    int result;
    @Override
    public void run() {
        int min = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        result = min;
    }

    public int getResult() {
        return this.result;
    }
}
// END
