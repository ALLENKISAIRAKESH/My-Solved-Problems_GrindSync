class Solution:
    def sumOfSquares(self, nums: List[int]) -> int:
        n = len(nums)
        s = 0
        for i in range(1, n + 1):
            if n % i == 0:
                s += nums[i - 1] ** 2
        return s