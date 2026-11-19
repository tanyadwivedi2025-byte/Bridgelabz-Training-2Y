
import java.util.Scanner;
public class StringIndexException {
    static void generateException(String text) {
        System.out.println(text.charAt(text.length()));
    }
    static void handleException(String text) {
        try {
            System.out.println(text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("String Index Out Of Bounds Exception Handled");
        } catch (RuntimeException e) {
            System.out.println("Runtime Exception Handled");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();
        try {
            generateException(text);
        } catch (RuntimeException e) {
            System.out.println("Runtime Exception Generated");
        }
        handleException(text);
        sc.close();
    }
}
