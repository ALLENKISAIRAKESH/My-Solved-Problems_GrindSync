class Solution:
    def minOperations(self, nums: list[int], x: int) -> int:
        t = sum(nums) - x
        if t < 0:
            return -1
        l = 0
        s = 0
        mx = -1
        for r in range(len(nums)):
            s += nums[r]
            while s > t:
                s -= nums[l]
                l += 1
            if s == t:
                mx = max(mx, r - l + 1)
        return len(nums) - mx if mx != -1 else -1
        