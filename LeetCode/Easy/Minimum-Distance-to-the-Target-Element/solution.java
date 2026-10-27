class Solution {
    public int getMinDistance(int[] nums, int target, int start) {

        /*
        🔥 APPROACH:

        From problem :contentReference[oaicite:0]{index=0}

        💡 Key Idea:
        Check all indices where nums[i] == target
        Track minimum |i - start|

        ------------------------------------------------

        ⏱ Time: O(n)
        */

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == target) {
                ans = Math.min(ans, Math.abs(i - start));
            }
        }

        return ans;
    }
}