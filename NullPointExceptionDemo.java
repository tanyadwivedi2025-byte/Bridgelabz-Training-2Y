public class NullPointExceptionDemo {
    static void generateException() {
        String text = null;
        System.out.println(text.length());
    }
    static void handleException() {
        try {
            generateException();
        }
        catch (NullPointerException e) {
            System.out.println("NullPointerException Handled!");
        }
    }
    public static void main(String[] args) {

        System.out.println("Program Started");

        handleException();

        System.out.println("Program Ended");
    }
}
