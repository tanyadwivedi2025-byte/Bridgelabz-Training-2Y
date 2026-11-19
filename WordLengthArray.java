
import java.util.Scanner;
public class WordLengthArray {
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
    static String[][] splitWords(String str) {
        int n = findLength(str);
        int count = 0;
        boolean inside = false;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) != ' ' && !inside) {
                count++;
                inside = true;
            } else if (str.charAt(i) == ' ') {
                inside = false;
            }
        }
        String[][] result = new String[count][2];
        int index = 0;
        String word = "";
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) != ' ') {
                word = word + str.charAt(i);
            } else if (!word.equals("")) {
                result[index][0] = word;
                result[index][1] = String.valueOf(findLength(word));
                index++;
                word = "";
            }
        }
        if (!word.equals("")) {
            result[index][0] = word;
            result[index][1] = String.valueOf(findLength(word));
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter complete text: ");
        String str = sc.nextLine();
        String[][] result = splitWords(str);
        System.out.println("Word\tLength");
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + "\t" + Integer.parseInt(result[i][1]));
        }
        sc.close();
    }
}
