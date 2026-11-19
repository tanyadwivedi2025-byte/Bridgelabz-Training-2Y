
import java.util.Scanner;
public class StringLength {
    static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.next();
        int result1 = findLength(str);
        int result2 = str.length();
        System.out.println("User Defined Length: " + result1);
        System.out.println("Built-in Length: " + result2);
        sc.close();
    }
}
