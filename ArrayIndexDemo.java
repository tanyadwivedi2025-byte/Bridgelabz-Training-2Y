
import java.util.Scanner;
public class ArrayIndexDemo {
    static void generateException(String[] names) {
        System.out.println(names[names.length]);
    }
    static void handleException(String[] names) {
        try {
            System.out.println(names[names.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index Out Of Bounds Exception Handled");
        } catch (RuntimeException e) {
            System.out.println("Runtime Exception Handled");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = new String[3];
        System.out.println("Enter 3 names:");
        for (int i = 0; i < names.length; i++) {
            names[i] = sc.nextLine();
        }
        try {
            generateException(names);
        } catch (RuntimeException e) {
            System.out.println("Runtime Exception Generated");
        }
        handleException(names);
        sc.close();
    }
}
