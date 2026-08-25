import java.util.HashMap;
import java.util.HashSet;

public class UniqueNumberOfOccurences {

    public static boolean uniqueOccurrences(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();    // Count occurrences
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // Check if occurrences are unique
        HashSet<Integer> set = new HashSet<>();

        for (int count : map.values()) {
            if (set.contains(count)) {
                return false;
            }
            set.add(count);
        }

        return true;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 1, 1, 3};

        boolean result = uniqueOccurrences(arr);

        System.out.println(result);
    }
}