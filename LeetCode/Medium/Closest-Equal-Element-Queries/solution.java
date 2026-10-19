class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {

        /*
        🔥 APPROACH: MAP + SORTED INDICES + BINARY SEARCH

        From problem :contentReference[oaicite:0]{index=0}

        💡 Key Idea:

        For each value → store ALL indices where it appears

        Then for each query:
        - find closest index in that list (circular distance)

        ------------------------------------------------

        ⏱ Time: O(n log n + q log n)
        */

        int n = nums.length;

        // map value → list of indices
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> ans = new ArrayList<>();

        for (int q : queries) {

            int val = nums[q];
            List<Integer> list = map.get(val);

            // if only one occurrence → no answer
            if (list.size() == 1) {
                ans.add(-1);
                continue;
            }

            int idx = Collections.binarySearch(list, q);

            int size = list.size();

            // previous index in circular manner
            int prev = list.get((idx - 1 + size) % size);

            // next index in circular manner
            int next = list.get((idx + 1) % size);

            int d1 = Math.abs(q - prev);
            int d2 = Math.abs(q - next);

            // circular distance
            int dist1 = Math.min(d1, n - d1);
            int dist2 = Math.min(d2, n - d2);

            ans.add(Math.min(dist1, dist2));
        }

        return ans;
    }
}