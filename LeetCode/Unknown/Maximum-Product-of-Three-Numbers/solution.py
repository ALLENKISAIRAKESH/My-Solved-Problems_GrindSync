class Solution:
    def maximumProduct(self, nums: list[int]) -> int:
        hi = heapq.nlargest(3, nums)
        lo = heapq.nsmallest(2, nums)
        return max(hi[0] * hi[1] * hi[2], lo[0] * lo[1] * hi[0])
