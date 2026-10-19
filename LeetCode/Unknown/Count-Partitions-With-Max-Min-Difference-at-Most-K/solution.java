class Solution {
    public int countPartitions(int[] nums, int k) {

        /*
        🔥 APPROACH: SLIDING WINDOW + DP

        From problem :contentReference[oaicite:0]{index=0}

        💡 Key Idea:

        Partition into segments where:
        max - min ≤ k

        ------------------------------------------------

        dp[i] = number of ways to partition first i elements

        ------------------------------------------------

        For each right index r:
        find leftmost index l such that
        window [l..r] is VALID

        Then:
        dp[r] = dp[l-1] + dp[l] + ... + dp[r-1]

        ------------------------------------------------

        Use prefix sum to optimize DP

        ------------------------------------------------

        Maintain window using:
        - deque for max
        - deque for min

        ------------------------------------------------

        ⏱ Time: O(n)
        */

        int n = nums.length;
        int MOD = 1_000_000_007;

        long[] dp = new long[n + 1];
        long[] prefix = new long[n + 1];

        dp[0] = 1;
        prefix[0] = 1;

        Deque<Integer> maxD = new ArrayDeque<>();
        Deque<Integer> minD = new ArrayDeque<>();

        int l = 0;

        for (int r = 0; r < n; r++) {

            // maintain max deque
            while (!maxD.isEmpty() && nums[maxD.peekLast()] <= nums[r]) {
                maxD.pollLast();
            }
            maxD.offerLast(r);

            // maintain min deque
            while (!minD.isEmpty() && nums[minD.peekLast()] >= nums[r]) {
                minD.pollLast();
            }
            minD.offerLast(r);

            // shrink window if invalid
            while (nums[maxD.peekFirst()] - nums[minD.peekFirst()] > k) {

                if (maxD.peekFirst() == l) maxD.pollFirst();
                if (minD.peekFirst() == l) minD.pollFirst();

                l++;
            }

            // dp transition
            dp[r + 1] = (prefix[r] - (l > 0 ? prefix[l - 1] : 0) + MOD) % MOD;

            prefix[r + 1] = (prefix[r] + dp[r + 1]) % MOD;
        }

        return (int) dp[n];
    }
}