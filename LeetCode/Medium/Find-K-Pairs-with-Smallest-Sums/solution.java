import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        /*
        🔥 APPROACH: Min Heap (Best-First Search)

        Key idea:
        - Arrays are sorted → smallest pair starts at (0,0)
        - Treat pairs like a grid:
              (i, j)
        - Use min heap based on sum

        Strategy:
        1. Start with (0,0)
        2. Always pick smallest sum
        3. From (i,j), push:
              (i, j+1)
              (i+1, j) → only when j == 0 (to avoid duplicates)

        ⏱ Time: O(k log k)
        💾 Space: O(k)
        */

        List<List<Integer>> res = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return res;
        }

        // Min heap: [i, j]
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]])
        );

        // Step 1: start with first pair
        pq.offer(new int[]{0, 0});

        while (k > 0 && !pq.isEmpty()) {

            int[] curr = pq.poll();
            int i = curr[0], j = curr[1];

            // add pair to result
            res.add(Arrays.asList(nums1[i], nums2[j]));
            k--;

            // Step 2: move right → (i, j+1)
            if (j + 1 < nums2.length) {
                pq.offer(new int[]{i, j + 1});
            }

            // Step 3: move down → (i+1, j)
            // only when j == 0 to avoid duplicates
            if (j == 0 && i + 1 < nums1.length) {
                pq.offer(new int[]{i + 1, 0});
            }
        }

        return res;
    }
}