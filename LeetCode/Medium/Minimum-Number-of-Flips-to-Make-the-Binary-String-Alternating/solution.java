class Solution {
    public int minFlips(String s) {

        /*
        🔥 APPROACH: Sliding Window + String Doubling

        From problem :contentReference[oaicite:0]{index=0}

        ------------------------------------------------

        💡 Key Idea:
        Since rotation is allowed → simulate by:
        s + s

        Now check all windows of size n

        ------------------------------------------------

        💡 Goal:
        Make string alternating → two patterns:
        1. "010101..."
        2. "101010..."

        Count mismatches for both

        ------------------------------------------------

        💡 Sliding Window:
        - Maintain mismatch count for both patterns
        - Window size = original length
        - Slide and update counts

        ------------------------------------------------

        ⏱ Time: O(n)
        */

        int n = s.length();
        String t = s + s;

        int alt1 = 0; // pattern 0101...
        int alt2 = 0; // pattern 1010...

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < t.length(); i++) {

            char c = t.charAt(i);

            // expected chars
            char e1 = (i % 2 == 0) ? '0' : '1';
            char e2 = (i % 2 == 0) ? '1' : '0';

            if (c != e1) alt1++;
            if (c != e2) alt2++;

            // shrink window
            if (i >= n) {
                char prev = t.charAt(i - n);

                char pe1 = ((i - n) % 2 == 0) ? '0' : '1';
                char pe2 = ((i - n) % 2 == 0) ? '1' : '0';

                if (prev != pe1) alt1--;
                if (prev != pe2) alt2--;
            }

            // valid window
            if (i >= n - 1) {
                res = Math.min(res, Math.min(alt1, alt2));
            }
        }

        return res;
    }
}