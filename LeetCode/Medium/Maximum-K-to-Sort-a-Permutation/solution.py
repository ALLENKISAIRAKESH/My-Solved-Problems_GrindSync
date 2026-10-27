class Solution:
    def sortPermutation(self, nums: List[int]) -> int:
        n = len(nums)
        ans = -1
        for i, x in enumerate(nums):
            if x != i:
                if ans == -1:
                    ans = x & i
                else:
                    ans &= x & i
        return max(ans, 0)