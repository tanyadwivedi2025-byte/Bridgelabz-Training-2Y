import java.util.*;

public class SumOfUniqueElements {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int sum = 0;

        // Add elements appearing only once
        for (int num : nums) {
            if (map.get(num) == 1) {
                sum += num;
            }
        }

        System.out.println("Sum of unique elements = " + sum);
    }
}
