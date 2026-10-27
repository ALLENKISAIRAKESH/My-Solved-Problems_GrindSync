class Solution {
    public int countSubmatrices(int[][] grid, int k) {

        /*
        🔥 APPROACH: 2D Prefix Sum

        From problem :contentReference[oaicite:0]{index=0}:

        👉 Only submatrices that include (0,0)

        So every valid submatrix is:
            (0,0) → (i,j)

        That means:
            just compute prefix sum for each (i,j)

        --------------------------------------------------

        💡 If prefixSum[i][j] <= k → count++

        --------------------------------------------------

        ⏱ Time: O(m*n)
        💾 Space: O(1) (can optimize without extra array)
        */

        int m = grid.length;
        int n = grid[0].length;

        int result = 0;

        // convert grid into prefix sum in-place
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i > 0) grid[i][j] += grid[i - 1][j];
                if (j > 0) grid[i][j] += grid[i][j - 1];
                if (i > 0 && j > 0) grid[i][j] -= grid[i - 1][j - 1];

                // check condition
                if (grid[i][j] <= k) {
                    result++;
                }
            }
        }

        return result;
    }
}