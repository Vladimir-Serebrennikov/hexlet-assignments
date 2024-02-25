package exercise;

import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] array) {
        MaxThread maxThread = new MaxThread(array);
        MinThread minThread = new MinThread(array);
        LOGGER.info("Starting maxThread...");
        maxThread.start();
        LOGGER.info("Starting minThread...");
        minThread.start();
        try {
            maxThread.join();
            minThread.join();
        } catch (InterruptedException ex) {
            LOGGER.log(Level.SEVERE, "Thread interrupted", ex);
        }
        LOGGER.info("maxThread finished its work.");
        LOGGER.info("minThread finished its work.");
        return Map.of("min", minThread.getResult(), "max", maxThread.getResult());
    }
    // END
}
