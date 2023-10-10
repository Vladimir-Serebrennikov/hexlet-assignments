package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    private final String original;
    public ReversedSequence(String original) {
        this.original = original;
    }
    @Override
    public int length() {
        return original.length();
    }

    @Override
    public char charAt(int index) {
        if (index < 0 || index >= original.length()) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        return original.charAt(original.length() - 1 - index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        String substring = original.substring(original.length() - end, original.length() - start);
        return new ReversedSequence(substring);
    }

    @Override
    public String toString() {
        StringBuilder reversed = new StringBuilder(original);
        return reversed.reverse().toString();
    }

    public static void main(String[] args) {
        CharSequence text = new ReversedSequence("abcdef");
        System.out.println(text.toString()); // "fedcba"
        System.out.println(text);
        System.out.println(text.charAt(1));
        System.out.println(text.length());
        System.out.println(text.subSequence(1, 4).toString());




    }

}
// END
