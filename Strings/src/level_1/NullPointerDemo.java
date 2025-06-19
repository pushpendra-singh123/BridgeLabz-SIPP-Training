package level_1;

public class NullPointerDemo {

    public static void throwNullPointer() {
        String text = null;
        System.out.println(text.length()); // Throws NPE
    }

    public static void handleNullPointer() {
        try {
            String text = null;
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException");
        }
    }

    public static void main(String[] args) {
        // throwNullPointer(); // Uncomment to test throwing
        handleNullPointer();
    }
}

