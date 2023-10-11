package exercise;


// BEGIN
class App {
    public static void swapKeyValue(KeyValueStorage data) {
        var entrySet = data.toMap().entrySet();

        for (var entry : entrySet) {
            data.unset(entry.getKey());
            data.set(entry.getValue(), entry.getKey());
        }
    }
}
// END
