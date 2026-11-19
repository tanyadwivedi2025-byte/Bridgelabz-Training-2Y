
import java.util.Scanner;
public class TrimSpaces {
    static int[] findPositions(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start < str.length() && str.charAt(start) == ' ') {
            start++;
        }
        while (end >= start && str.charAt(end) == ' ') {
            end--;
        }
        return new int[]{start, end + 1};
    }
    static String createSubstring(String str, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result = result + str.charAt(i);
        }
        return result;
    }
    static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string with spaces: ");
        String str = sc.nextLine();
        int[] position = findPositions(str);
        String result1 = createSubstring(str, position[0], position[1]);
        String result2 = str.trim();
        System.out.println("Using charAt(): " + result1);
        System.out.println("Using trim(): " + result2);
        System.out.println("Both are same: " + compareStrings(result1, result2));
        sc.close();
    }
}
