class Solution {
    public boolean kLengthApart(int[] nums, int k) {

        /*
        🔥 APPROACH:

        From problem :contentReference[oaicite:0]{index=0}

        💡 Idea:
        Track last seen index of '1'

        For every new '1':
        check distance from previous '1'

        ------------------------------------------------

        If distance <= k → return false

        ------------------------------------------------

        ⏱ Time: O(n)
        */

        int last = -1; // last index where '1' appeared

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 1) {

                if (last != -1 && i - last <= k) {
                    return false;
                }

                last = i; // update last seen position
            }
        }

        return true;
    }
}