import java.util.Scanner;
public class SubstringCompare {
    static String createSubstring(String str, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result = result + str.charAt(i);
        }
        return result;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.next();

        System.out.print("Enter start index: ");
        int start = sc.nextInt();

        System.out.print("Enter end index: ");
        int end = sc.nextInt();

        String result1 = createSubstring(str, start, end);
        String result2 = str.substring(start, end);

        System.out.println("Using charAt(): " + result1);
        System.out.println("Using substring(): " + result2);

        System.out.println("Both are same: " + result1.equals(result2));

        sc.close();
    }
}
