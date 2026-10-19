class Solution {
    public boolean hasAllCodes(String s, int k) {

        /*
        🔥 APPROACH: Sliding Window + Bitmask

        From problem :contentReference[oaicite:0]{index=0}

        💡 Key Idea:
        Total binary codes of length k = 2^k

        We need to check if ALL appear in s

        -----------------------------------------

        💡 Trick:
        Instead of substring + set (slow),
        use rolling bitmask

        window of size k → convert to number

        -----------------------------------------

        Example:
        s = "00110110", k = 2

        substrings:
        "00" → 0
        "01" → 1
        "11" → 3
        "10" → 2

        -----------------------------------------

        ⏱ Time: O(n)
        */

        int need = 1 << k; // total possible codes
        boolean[] seen = new boolean[need];

        int mask = 0;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            // build rolling window
            mask = ((mask << 1) & (need - 1)) | (s.charAt(i) - '0');

            // start checking when window size >= k
            if (i >= k - 1) {
                if (!seen[mask]) {
                    seen[mask] = true;
                    count++;

                    if (count == need) return true;
                }
            }
        }

        return false;
    }
}