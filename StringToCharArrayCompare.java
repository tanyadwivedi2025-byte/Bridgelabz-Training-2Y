import java.util.Scanner;
public class StringToCharArrayCompare {
    static char[] getCharacters(String str) {
        char[] arr = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }

        return arr;
    }

    static boolean compareArrays(char[] a, char[] b) {

        if (a.length != b.length) {
            return false;
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.next();

        char[] arr1 = getCharacters(str);
        char[] arr2 = str.toCharArray();

        System.out.println("Using User Defined Method:");

        for (char ch : arr1) {
            System.out.print(ch + " ");
        }

        System.out.println("\nUsing toCharArray():");

        for (char ch : arr2) {
            System.out.print(ch + " ");
        }

        System.out.println("\nBoth arrays are same: "
                + compareArrays(arr1, arr2));

        sc.close();
    }
}

