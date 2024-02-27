package exercise;

// BEGIN
public class ListThread extends Thread{
    private SafetyList safetyList;
    public ListThread(SafetyList safetyList) {
        this.safetyList = safetyList;
    }
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                sleep(1);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            safetyList.add(i);
        }
    }
}
// END
