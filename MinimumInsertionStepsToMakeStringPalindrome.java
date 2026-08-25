public class MinimumInsertionStepsToMakeStringPalindrome{

    public static int minInsertions(String s) {

        int n = s.length();

        // dp[i][j] = minimum insertions needed
        // to make substring s[i...j] a palindrome
        int[][] dp = new int[n][n];

        for (int length = 2; length <= n; length++) {

            for (int i = 0; i + length <= n; i++) {

                int j = i + length - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {

        String s = "zzazz";

        int result = minInsertions(s);

        System.out.println(result);
    }
}
