class Solution {
    public int concatenatedBinary(int n) {

        /*
        🔥 APPROACH:

        From problem :contentReference[oaicite:0]{index=0}

        💡 Idea:
        We keep building the result by shifting and adding numbers.

        Example:
        1 → "1"
        2 → "110"
        3 → "11011"

        -----------------------------------------

        💡 Key Trick:
        Instead of converting to string:

        result = (result << bits_of_i) | i

        👉 bits_of_i = number of bits in i

        -----------------------------------------

        💡 Optimization:
        bits increases when i is power of 2

        (1,2,4,8,16...)

        So:
        if ((i & (i - 1)) == 0) → increase bit count

        -----------------------------------------

        ⏱ Time: O(n)
        */

        int MOD = 1_000_000_007;
        long res = 0;
        int bits = 0;

        for (int i = 1; i <= n; i++) {

            // if power of 2 → increase bit length
            if ((i & (i - 1)) == 0) {
                bits++;
            }

            res = ((res << bits) | i) % MOD;
        }

        return (int) res;
    }
}