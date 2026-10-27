class Solution {
    public int maxSumDivThree(int[] nums) {

        /*
        🔥 APPROACH: DP (MOD 3 STATES)

        From problem :contentReference[oaicite:0]{index=0}

        💡 Key Idea:

        Track maximum sum with remainder:
        dp[0] → sum % 3 == 0
        dp[1] → sum % 3 == 1
        dp[2] → sum % 3 == 2

        ------------------------------------------------

        For each number:
        try adding it to all previous states

        ------------------------------------------------

        ⏱ Time: O(n)
        */

        int[] dp = new int[3]; // initialized to 0

        for (int num : nums) {

            int[] next = dp.clone();

            for (int r = 0; r < 3; r++) {

                int newSum = dp[r] + num;
                int newRem = newSum % 3;

                next[newRem] = Math.max(next[newRem], newSum);
            }

            dp = next;
        }

        return dp[0]; // max sum divisible by 3
    }
}