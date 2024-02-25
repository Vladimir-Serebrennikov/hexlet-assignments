package exercise;

import java.lang.Thread;

// BEGIN
public class MaxThread extends Thread {
    private int[] array;
    public MaxThread(int[] array) {
        this.array = array;
    }
    int result;
    @Override
    public void run() {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        result = max;
    }

    public int getResult() {
        return this.result;
    }
}
// END
