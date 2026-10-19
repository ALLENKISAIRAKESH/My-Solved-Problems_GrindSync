class Solution {
    public int minimumDistance(int[] nums) {

        /*
        🔥 APPROACH:

        From problem :contentReference[oaicite:0]{index=0}

        💡 Key Insight:

        Distance for (i, j, k):
        |i - j| + |j - k| + |k - i|

        If i < j < k:
        = (j - i) + (k - j) + (k - i)
        = 2 * (k - i)

        👉 So we only need:
        pick 3 same numbers → minimize (k - i)

        -----------------------------------------

        💡 Strategy:

        For each number:
        - collect indices
        - if >= 3:
            check every consecutive triple
            minimize (last - first)

        -----------------------------------------

        ⏱ Time: O(n)
        */

        Map<Integer, List<Integer>> map = new HashMap<>();

        // collect indices
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], x -> new ArrayList<>()).add(i);
        }

        int ans = Integer.MAX_VALUE;

        for (List<Integer> list : map.values()) {

            if (list.size() < 3) continue;

            for (int i = 0; i + 2 < list.size(); i++) {
                int dist = list.get(i + 2) - list.get(i);
                ans = Math.min(ans, dist);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : 2 * ans;
    }
}