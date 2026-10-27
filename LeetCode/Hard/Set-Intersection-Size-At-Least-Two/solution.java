class Solution {
    public int intersectionSizeTwo(int[][] intervals) {

        /*
        🔥 APPROACH: GREEDY + SORTING

        From problem :contentReference[oaicite:0]{index=0}

        💡 Key Idea:

        We must pick minimum points such that
        every interval contains at least 2 points

        ------------------------------------------------

        💡 Strategy:

        1. Sort intervals:
           - by end ASC
           - if tie → start DESC

        2. Maintain last two picked points: p1, p2

        3. For each interval:
           - if both p1, p2 inside → do nothing
           - if only one inside → add 1 more point
           - if none inside → add 2 points

        Always pick from END (greedy optimal)

        ------------------------------------------------

        ⏱ Time: O(n log n)
        */

        Arrays.sort(intervals, (a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            return b[0] - a[0];
        });

        int p1 = -1, p2 = -1; // last two points
        int ans = 0;

        for (int[] in : intervals) {

            int start = in[0], end = in[1];

            // case 1: both points already inside
            if (start <= p1) {
                continue;
            }

            // case 2: only one point inside
            else if (start <= p2) {
                ans += 1;
                p1 = p2;
                p2 = end;
            }

            // case 3: none inside
            else {
                ans += 2;
                p1 = end - 1;
                p2 = end;
            }
        }

        return ans;
    }
}