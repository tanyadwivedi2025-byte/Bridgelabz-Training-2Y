import java.util.HashMap;

public class FindLuckyIntegerInAnArray {

    public static int findLucky(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency of each number
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Find the largest lucky number
        int lucky = -1;

        for (int num : map.keySet()) {
            if (map.get(num) == num) {
                lucky = Math.max(lucky, num);
            }
        }

        return lucky;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 3, 3, 3};

        int result = findLucky(arr);

        System.out.println(result);
    }
}
