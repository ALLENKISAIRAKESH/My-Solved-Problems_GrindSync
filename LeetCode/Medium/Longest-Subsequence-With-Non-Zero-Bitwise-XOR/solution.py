class Solution:
    def longestSubsequence(self, nums: List[int]) -> int:
        x = 0
        for i in nums:
            x ^= i
        if x != 0:
            return len(nums)
        for i in nums:
            if i != 0:
                return len(nums) - 1
        return 0