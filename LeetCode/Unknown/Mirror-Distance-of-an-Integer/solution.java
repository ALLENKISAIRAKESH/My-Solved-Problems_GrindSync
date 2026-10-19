class Solution {
    public int mirrorDistance(int n) {

        /*
        🔥 APPROACH:

        From problem :contentReference[oaicite:0]{index=0}

        💡 Key Idea:

        1. Reverse the digits of n
        2. Return absolute difference

        ------------------------------------------------

        ⏱ Time: O(digits)
        */

        int original = n;
        int rev = 0;

        // reverse number
        while (n > 0) {
            rev = rev * 10 + (n % 10);
            n /= 10;
        }

        return Math.abs(original - rev);
    }
}