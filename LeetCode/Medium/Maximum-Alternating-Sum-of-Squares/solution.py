class Solution:
    def maxAlternatingSum(self, nums: List[int]) -> int:
        squares = sorted((x * x for x in nums), reverse=True)
        n = len(nums)
        half = n // 2
        return sum(squares[:n - half]) - sum(squares[n - half:])
