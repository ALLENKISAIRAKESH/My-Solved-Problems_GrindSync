class Solution {
    public int maxProductPath(int[][] grid) {

        /*
        🔥 APPROACH: DP with Max & Min tracking

        From problem :contentReference[oaicite:0]{index=0}:

        👉 Key challenge:
        - Negative numbers flip sign
        - So we must track BOTH:
            max product till cell
            min product till cell

        WHY?
        - (-ve * -ve) → positive (can become max!)
        - (+ve * -ve) → negative (can become min!)

        -------------------------------------------------

        💡 DP Definition:
        max[i][j] = max product reaching (i,j)
        min[i][j] = min product reaching (i,j)

        Transition:
        from top OR left:
            consider BOTH max & min

        -------------------------------------------------

        ⏱ Time: O(m*n)
        💾 Space: O(m*n)
        */

        int m = grid.length, n = grid[0].length;
        long MOD = 1_000_000_007;

        long[][] max = new long[m][n];
        long[][] min = new long[m][n];

        // base case
        max[0][0] = grid[0][0];
        min[0][0] = grid[0][0];

        // first column
        for (int i = 1; i < m; i++) {
            max[i][0] = max[i - 1][0] * grid[i][0];
            min[i][0] = max[i][0];
        }

        // first row
        for (int j = 1; j < n; j++) {
            max[0][j] = max[0][j - 1] * grid[0][j];
            min[0][j] = max[0][j];
        }

        // fill DP
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                long val = grid[i][j];

                long a = max[i - 1][j] * val;
                long b = min[i - 1][j] * val;
                long c = max[i][j - 1] * val;
                long d = min[i][j - 1] * val;

                max[i][j] = Math.max(Math.max(a, b), Math.max(c, d));
                min[i][j] = Math.min(Math.min(a, b), Math.min(c, d));
            }
        }

        long ans = max[m - 1][n - 1];

        // if negative → return -1
        if (ans < 0) return -1;

        return (int)(ans % MOD);
    }
}