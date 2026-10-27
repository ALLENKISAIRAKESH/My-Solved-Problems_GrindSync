class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int total = 0;
        for (int x : nums) {
            total += x;
        }

        int leftSum = 0;

        for (int i = 0; i < n; i++) {
            int rightSum = total - leftSum - nums[i];
            ans[i] = Math.abs(leftSum - rightSum);
            leftSum += nums[i];
        }

        return ans;
    }
}