class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        // 🔥 This is Problem 3653 (I) → constraints small (n, q ≤ 1000)
        // So simple brute is optimal + clean

        int MOD = 1_000_000_007;

        // Process each query directly
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            int k = q[2];
            int v = q[3];

            // Apply updates with step k
            for (int i = l; i <= r; i += k) {
                nums[i] = (int)((long)nums[i] * v % MOD);
            }
        }

        // Compute XOR of final array
        int xor = 0;
        for (int x : nums) {
            xor ^= x;
        }

        return xor;
    }
}