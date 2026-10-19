class Solution:
    def resultArray(self, nums: List[int], k: int) -> List[int]:
        a = [0] * k
        dp = [0] * k
        for x in nums:
            x %= k
            ndp = [0] * k
            ndp[x] += 1
            for r in range(k):
                ndp[(r * x) % k] += dp[r]
            dp = ndp
            for r in range(k):
                a[r] += dp[r]
        return a