import java.util.*;

class Solution {
    public List<String> buildArray(int[] target, int n) {

        /*
        🔥 APPROACH: Simulation (Greedy)

        Key idea:
        - We read numbers from stream: 1 → n
        - Maintain pointer on target array

        For each number i from 1 to n:
            - Always "Push" (we must read it)
            - If i == target[j]:
                → keep it (move j++)
            - Else:
                → immediately "Pop"

        Stop when target is fully built

        ⏱ Time: O(n)
        💾 Space: O(1) (excluding output)
        */

        List<String> res = new ArrayList<>();

        int j = 0; // pointer for target

        for (int i = 1; i <= n && j < target.length; i++) {

            // Always push current number
            res.add("Push");

            if (i == target[j]) {
                // correct number → keep it
                j++;
            } else {
                // not needed → remove it
                res.add("Pop");
            }
        }

        return res;
    }
}