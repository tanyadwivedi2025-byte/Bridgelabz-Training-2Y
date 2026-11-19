
import java.util.Scanner;
public class IllegalArgumentDemo {
    static void generateException(String text) {
        System.out.println(text.substring(5, 2));
    }
    static void handleException(String text) {
        try {
            System.out.println(text.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal Argument Exception Handled");
        } catch (RuntimeException e) {
            System.out.println("Runtime Exception Handled");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string (minimum 6 characters): ");
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
