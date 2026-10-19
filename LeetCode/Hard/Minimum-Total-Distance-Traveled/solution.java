class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {

        /*
        🔥 APPROACH: SORT + DP (ASSIGNMENT PROBLEM)

        From problem :contentReference[oaicite:0]{index=0}

        💡 Key Idea:

        Sort robots and factories

        DP[i][j] = min cost to assign first i robots
                   using first j factories

        ------------------------------------------------

        For each factory:
        try assigning 0 → limit robots

        ------------------------------------------------

        ⏱ Time: O(n * m * limit)
        (n, m ≤ 100 → OK)
        */

        int n = robot.size();
        int m = factory.length;

        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);

        long[][] dp = new long[n + 1][m + 1];

        for (long[] row : dp) Arrays.fill(row, Long.MAX_VALUE);
        dp[0][0] = 0;

        for (int j = 1; j <= m; j++) {

            int pos = factory[j - 1][0];
            int limit = factory[j - 1][1];

            for (int i = 0; i <= n; i++) {

                // skip this factory
                dp[i][j] = dp[i][j - 1];

                long cost = 0;

                // assign k robots to this factory
                for (int k = 1; k <= limit && i - k >= 0; k++) {

                    cost += Math.abs(robot.get(i - k) - pos);

                    if (dp[i - k][j - 1] != Long.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j],
                                dp[i - k][j - 1] + cost);
                    }
                }
            }
        }

        return dp[n][m];
    }
}
