class Solution:
    def maxSum(self, nums: List[int], k: int) -> int:
        c = [0] * 32
        m = 10**9 + 7
        for x in nums:
            for i in range(32):
                if x & (1 << i):
                    c[i] += 1
        a = 0
        for _ in range(k):
            x = 0
            for i in range(32):
                if c[i]:
                    x |= 1 << i
                    c[i] -= 1
            a = (a + x * x) % m
        return a