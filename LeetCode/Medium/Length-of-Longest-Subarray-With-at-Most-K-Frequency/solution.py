class Solution:
    def maxSubarrayLength(self, nums, k):
        d = {}
        l = 0
        ans = 0
        for r in range(len(nums)):
            d[nums[r]] = d.get(nums[r], 0) + 1
            while d[nums[r]] > k:
                d[nums[l]] -= 1
                l += 1
            ans = max(ans, r - l + 1)
        return ans