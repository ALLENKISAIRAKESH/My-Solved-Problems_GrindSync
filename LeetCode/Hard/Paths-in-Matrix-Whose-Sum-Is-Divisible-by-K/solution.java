class Solution {
    public int numberOfPaths(int[][] grid, int k) {

        /*
        🔥 APPROACH: 3D DP (MODULO STATE)

        From problem :contentReference[oaicite:0]{index=0}

        💡 Key Idea:

        dp[i][j][r] = number of ways to reach (i,j)
                      with sum % k == r

        ------------------------------------------------

        Transition:
        From top (i-1, j) and left (i, j-1)

        new remainder:
        (prev_rem + grid[i][j]) % k

        ------------------------------------------------

        ⏱ Time: O(m * n * k)
        */

        int MOD = 1_000_000_007;
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][k];

        // base case
        dp[0][0][grid[0][0] % k] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                for (int r = 0; r < k; r++) {

                    int ways = dp[i][j][r];
                    if (ways == 0) continue;

                    // move down
                    if (i + 1 < m) {
                        int nr = (r + grid[i + 1][j]) % k;
                        dp[i + 1][j][nr] = (dp[i + 1][j][nr] + ways) % MOD;
                    }

                    // move right
                    if (j + 1 < n) {
                        int nr = (r + grid[i][j + 1]) % k;
                        dp[i][j + 1][nr] = (dp[i][j + 1][nr] + ways) % MOD;
                    }
                }
            }
        }

        return dp[m - 1][n - 1][0]; // divisible by k
    }
}