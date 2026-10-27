class Solution {
    public int[][] constructProductMatrix(int[][] grid) {

        /*
        🔥 APPROACH: Prefix Product + Suffix Product (Flattened)

        From problem :contentReference[oaicite:0]{index=0}:

        Goal:
        - For each cell → product of ALL elements except itself
        - Take mod = 12345

        🚫 Division NOT allowed (because of mod + zeros)

        ✅ Trick:
        Convert 2D → 1D
        Then apply:
            prefix product * suffix product

        Example:
        nums = [a, b, c, d]

        prefix: [1, a, a*b, a*b*c]
        suffix: [b*c*d, c*d, d, 1]

        result[i] = prefix[i] * suffix[i]

        ⏱ Time: O(n*m)
        💾 Space: O(n*m)
        */

        int m = grid.length;
        int n = grid[0].length;
        int size = m * n;

        int MOD = 12345;

        // Step 1: Flatten grid → 1D array
        long[] arr = new long[size];
        int idx = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[idx++] = grid[i][j] % MOD;
            }
        }

        // Step 2: Prefix product
        long[] prefix = new long[size];
        prefix[0] = 1;

        for (int i = 1; i < size; i++) {
            prefix[i] = (prefix[i - 1] * arr[i - 1]) % MOD;
        }

        // Step 3: Suffix product
        long[] suffix = new long[size];
        suffix[size - 1] = 1;

        for (int i = size - 2; i >= 0; i--) {
            suffix[i] = (suffix[i + 1] * arr[i + 1]) % MOD;
        }

        // Step 4: Build result
        int[][] result = new int[m][n];
        idx = 0;

        for (int i = 0; i < size; i++) {
            long val = (prefix[i] * suffix[i]) % MOD;

            result[i / n][i % n] = (int) val;
        }

        return result;
    }
}