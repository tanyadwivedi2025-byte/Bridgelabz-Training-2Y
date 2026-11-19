
import java.util.Scanner;
public class SplitCompare {
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
    static String[] splitText(String str) {
        int n = findLength(str);
        int words = 0;
        boolean inside = false;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) != ' ' && !inside) {
                words++;
                inside = true;
            } else if (str.charAt(i) == ' ') {
                inside = false;
            }
        }
        String[] result = new String[words];
        int index = 0;
        String word = "";
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) != ' ') {
                word = word + str.charAt(i);
            } else if (!word.equals("")) {
                result[index++] = word;
                word = "";
            }
        }
        if (!word.equals("")) {
            result[index] = word;
        }
        return result;
    }
    static boolean compareArrays(String[] a, String[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter complete text: ");
        String str = sc.nextLine();
        String[] result1 = splitText(str);
        String[] result2 = str.trim().split("\\s+");
        System.out.println("Using charAt():");
        for (String word : result1) System.out.println(word);
        System.out.println("Using split():");
        for (String word : result2) System.out.println(word);
        System.out.println("Both are same: " + compareArrays(result1, result2));
        sc.close();
    }
}
