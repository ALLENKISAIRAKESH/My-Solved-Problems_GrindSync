import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        /*
        🔥 APPROACH: In-place marking (Index Mapping)

        Key idea:
        - Numbers are in range [1, n]
        - Each number maps to an index: num → index (num - 1)

        Trick:
        - Mark visited indices by making nums[index] negative
        - If index is already negative → already visited

        After marking:
        - Any index i with positive value → (i + 1) is missing

        ⏱ Time: O(n)
        💾 Space: O(1) (excluding output)
        */

        int n = nums.length;

        // Step 1: mark visited indices
        for (int i = 0; i < n; i++) {

            // get index using absolute value (important!)
            int idx = Math.abs(nums[i]) - 1;

            // mark as visited by making negative
            if (nums[idx] > 0) {
                nums[idx] = -nums[idx];
            }
        }

        List<Integer> res = new ArrayList<>();

        // Step 2: find missing numbers
        for (int i = 0; i < n; i++) {

            // if positive → index not visited
            if (nums[i] > 0) {
                res.add(i + 1); // number missing
            }
        }

        return res;
    }
}