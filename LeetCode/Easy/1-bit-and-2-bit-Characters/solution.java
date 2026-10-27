class Solution {
    public boolean isOneBitCharacter(int[] bits) {

        /*
        🔥 APPROACH:

        From problem :contentReference[oaicite:0]{index=0}

        💡 Idea:
        Traverse using jumps

        - If bit == 0 → move 1 step (one-bit char)
        - If bit == 1 → move 2 steps (two-bit char)

        ------------------------------------------------

        Stop before last element

        If we land exactly on last index → last is 1-bit char

        ------------------------------------------------

        ⏱ Time: O(n)
        */

        int i = 0;
        int n = bits.length;

        // stop before last index
        while (i < n - 1) {

            if (bits[i] == 1) {
                i += 2; // two-bit character
            } else {
                i += 1; // one-bit character
            }
        }

        // if we reached exactly last index
        return i == n - 1;
    }
}