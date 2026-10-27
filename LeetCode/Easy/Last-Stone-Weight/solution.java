import java.util.*;

class Solution {
    public int lastStoneWeight(int[] stones) {

        /*
        🔥 APPROACH: Max Heap (Priority Queue)

        Key idea:
        - Always pick the 2 largest stones
        - Heap helps get max in O(log n)

        Steps:
        1. Put all stones into max heap
        2. While size > 1:
            - remove two largest (y ≥ x)
            - if y != x → insert (y - x)
        3. Return remaining element or 0

        ⏱ Time: O(n log n)
        💾 Space: O(n)
        */

        // max heap (reverse order)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Step 1: add all stones
        for (int s : stones) {
            maxHeap.offer(s);
        }

        // Step 2: simulate smashing
        while (maxHeap.size() > 1) {

            int y = maxHeap.poll(); // largest
            int x = maxHeap.poll(); // second largest

            if (y != x) {
                maxHeap.offer(y - x);
            }
        }

        // Step 3: return result
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}