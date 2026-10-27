class Solution {
    public int findFinalValue(int[] nums, int original) {

        /*
        🔥 APPROACH:

        From problem :contentReference[oaicite:0]{index=0}

        💡 Idea:
        Keep checking if current value exists in array

        If yes → double it
        Repeat until it no longer exists

        ------------------------------------------------

        💡 Optimization:
        Use HashSet for O(1) lookup

        ------------------------------------------------

        ⏱ Time: O(n)
        */

        // store all numbers in set
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // keep doubling while found
        while (set.contains(original)) {
            original *= 2;
        }

        return original;
    }
}