class Solution {
    public int bitwiseComplement(int n) {

        /*
        🔥 APPROACH:

        Complement means:
        - Flip all bits of number
        - But ONLY up to its highest set bit (ignore leading zeros)

        Example:
        n = 5 → binary = 101
        mask = 111
        answer = 101 ^ 111 = 010 = 2

        ------------------------------------------------

        💡 Steps:
        1. Handle edge case n == 0 → return 1
        2. Create mask of all 1's of same length as n
        3. XOR n with mask

        ------------------------------------------------

        ⏱ Time: O(1)
        */

        if (n == 0) return 1;

        int mask = 0;
        int temp = n;

        // build mask like 111... (same length as n)
        while (temp > 0) {
            mask = (mask << 1) | 1;
            temp >>= 1;
        }

        return n ^ mask;
    }
}