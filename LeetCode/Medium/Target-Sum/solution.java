class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int num : nums) total += num;

        if (Math.abs(target) > total || ((total + target) & 1) == 1) return 0;
        int req = (total + target) / 2;

        int[] dp = new int[req + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int s = req; s >= num; s--) {
                dp[s] += dp[s - num];
            }
        }
        return dp[req];
    }
}