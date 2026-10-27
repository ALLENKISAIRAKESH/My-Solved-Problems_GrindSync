class Solution {
    public int smallestRepunitDivByK(int k) {

        /*
        🔥 APPROACH:

        From problem :contentReference[oaicite:0]{index=0}

        💡 Key Idea:
        Build number like:
        1 → 11 → 111 → ...

        BUT we only track remainder (mod k)

        ------------------------------------------------

        💡 Formula:
        remainder = (remainder * 10 + 1) % k

        ------------------------------------------------

        If remainder becomes 0 → divisible

        If we loop more than k times → cycle → impossible

        ------------------------------------------------

        ⏱ Time: O(k)
        */

        // quick reject
        if (k % 2 == 0 || k % 5 == 0) return -1;

        int rem = 0;

        for (int len = 1; len <= k; len++) {

            rem = (rem * 10 + 1) % k;

            if (rem == 0) {
                return len;
            }
        }

        return -1; // cycle detected
    }
}