class Solution {
    public int minimumOperations(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ops = 0;
        for (int col = 0; col < n; col++) {
            for (int row = 1; row < m; row++) {
                if (grid[row][col] <= grid[row - 1][col]) {
                    int need = grid[row - 1][col] + 1;
                    ops += need - grid[row][col];
                    grid[row][col] = need;
                }
            }
        }
        return ops;
    }
}