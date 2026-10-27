class Solution {
    public int subsetXORSum(int[] nums) {
        return dfs(nums, 0, 0);
    }

    private int dfs(int[] nums, int idx, int xor) {
        if (idx == nums.length) return xor;
        return dfs(nums, idx + 1, xor ^ nums[idx]) + dfs(nums, idx + 1, xor);
    }
}