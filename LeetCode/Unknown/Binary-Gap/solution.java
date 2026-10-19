class Solution {
    public int binaryGap(int n) {

        /*
        🔥 APPROACH:

        From problem :contentReference[oaicite:0]{index=0}

        💡 Idea:
        Find distance between consecutive '1' bits

        Example:
        n = 22 → binary = 10110

        positions of 1s:
        index: 0 1 2 3 4
               1 0 1 1 0

        gaps:
        between index 0 and 2 → 2
        between index 2 and 3 → 1

        answer = max = 2

        -----------------------------------------

        💡 Trick:
        Track last position of '1'

        -----------------------------------------

        ⏱ Time: O(log n)
        */

        int last = -1;
        int index = 0;
        int maxGap = 0;

        while (n > 0) {

            if ((n & 1) == 1) {
                if (last != -1) {
                    maxGap = Math.max(maxGap, index - last);
                }
                last = index;
            }

            n >>= 1;
            index++;
        }

        return maxGap;
    }
}