
import java.util.Scanner;
public class NumberFormatDemo {
    static void generateException(String text) {
        int number = Integer.parseInt(text);
        System.out.println(number);
    }
    static void handleException(String text) {
        try {
            int number = Integer.parseInt(text);
            System.out.println("Number = " + number);
        } catch (NumberFormatException e) {
            System.out.println("Number Format Exception Handled");
        } catch (RuntimeException e) {
            System.out.println("Runtime Exception Handled");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
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
