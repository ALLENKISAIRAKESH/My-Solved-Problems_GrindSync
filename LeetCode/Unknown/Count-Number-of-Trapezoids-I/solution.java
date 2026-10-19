class Solution {
    public int countTrapezoids(int[][] points) {

        /*
        🔥 APPROACH: GROUP BY Y + COMBINATORICS

        From problem :contentReference[oaicite:0]{index=0}

        💡 Key Idea:

        Horizontal trapezoid ⇒ need TWO horizontal lines
        (same y)

        ------------------------------------------------

        Steps:

        1. Group points by y-coordinate
        2. For each y:
           count how many points → cnt

           number of ways to pick 2 points from this line:
           pairs = cnt * (cnt - 1) / 2

        3. Now choose 2 DIFFERENT horizontal lines:
           combine their pairs

        ------------------------------------------------

        💡 Final:
        sum over all pairs of lines:
        pairs[i] * pairs[j]

        ------------------------------------------------

        ⏱ Time: O(n)
        */

        int MOD = 1_000_000_007;

        // count points per y
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] p : points) {
            map.put(p[1], map.getOrDefault(p[1], 0) + 1);
        }

        // store number of pairs per horizontal line
        List<Long> list = new ArrayList<>();

        for (int cnt : map.values()) {
            if (cnt >= 2) {
                long pairs = (long) cnt * (cnt - 1) / 2;
                list.add(pairs);
            }
        }

        long ans = 0;
        long prefixSum = 0;

        // combine pairs from different lines
        for (long p : list) {
            ans = (ans + p * prefixSum) % MOD;
            prefixSum = (prefixSum + p) % MOD;
        }

        return (int) ans;
    }
}