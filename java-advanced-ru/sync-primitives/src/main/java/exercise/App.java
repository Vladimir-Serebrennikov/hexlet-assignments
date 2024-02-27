package exercise;

class App {

    public static void main(String[] args) {
        // BEGIN
        var safetyList = new SafetyList();
        var thread1 = new ListThread(safetyList);
        var thread2 = new ListThread(safetyList);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        System.out.println(safetyList.getSize());
        // END
    }
}

