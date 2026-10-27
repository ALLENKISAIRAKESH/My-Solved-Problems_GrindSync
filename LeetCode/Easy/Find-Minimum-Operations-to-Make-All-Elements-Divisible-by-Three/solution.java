class Solution {
    public int minimumOperations(int[] nums) {

        /*
        🔥 APPROACH:

        From problem :contentReference[oaicite:0]{index=0}

        💡 Key Idea:
        We want every number divisible by 3

        For each num:
        remainder = num % 3

        ------------------------------------------------

        💡 Cases:

        remainder = 0 → already fine → 0 ops

        remainder = 1 → best is:
            - subtract 1 → 1 operation

        remainder = 2 → best is:
            - add 1 → 1 operation

        ------------------------------------------------

        So each non-zero remainder → 1 operation

        ------------------------------------------------

        ⏱ Time: O(n)
        */

        int ops = 0;

        for (int num : nums) {
            if (num % 3 != 0) {
                ops++;
            }
        }

        return ops;
    }
}
