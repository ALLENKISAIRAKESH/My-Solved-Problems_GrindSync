class Solution {
    public long maxSubarraySum(int[] nums, int k) {

        /*
        🔥 APPROACH: PREFIX SUM + MOD GROUPING

        From problem :contentReference[oaicite:0]{index=0}

        💡 Key Idea:

        Subarray length divisible by k:
        (j - i) % k == 0

        👉 So:
        prefix index % k must be SAME

        ------------------------------------------------

        💡 Trick:

        Group prefix sums by index % k

        For each remainder r:
        we want max (prefix[j] - min prefix[i])

        ------------------------------------------------

        ⏱ Time: O(n)
        */

        int n = nums.length;

        long prefix = 0;
        long ans = Long.MIN_VALUE;

        // min prefix sum for each remainder
        long[] minPrefix = new long[k];
        Arrays.fill(minPrefix, Long.MAX_VALUE);

        minPrefix[0] = 0; // base case

        for (int i = 0; i < n; i++) {

            prefix += nums[i];

            int mod = (i + 1) % k;

            if (minPrefix[mod] != Long.MAX_VALUE) {
                ans = Math.max(ans, prefix - minPrefix[mod]);
            }

            minPrefix[mod] = Math.min(minPrefix[mod], prefix);
        }

        return ans;
    }
}