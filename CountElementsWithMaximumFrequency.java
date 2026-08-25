import java.util.HashMap;

public class CountElementsWithMaximumFrequency {

    public static int maxFrequencyElements(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency of each element
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Find maximum frequency
        int maxFrequency = 0;

        for (int frequency : map.values()) {
            maxFrequency = Math.max(maxFrequency, frequency);
        }

        // Count total elements having maximum frequency
        int result = 0;

        for (int frequency : map.values()) {
            if (frequency == maxFrequency) {
                result += frequency;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 2, 3, 1, 4};

        int result = maxFrequencyElements(nums);

        System.out.println(result);
    }
}
