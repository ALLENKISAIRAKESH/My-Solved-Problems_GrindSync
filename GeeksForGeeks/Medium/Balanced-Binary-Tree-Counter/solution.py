class Solution:
    def countBT(self, h: int) -> int:
        MOD = 10**9 + 7
        if h == 0:
            return 1
        if h == 1:
            return 1
        dp0 = 1 
        dp1 = 1  
        for i in range(2, h + 1):
            dp2 = (dp1 * dp1 + 2 * dp1 * dp0) % MOD
            dp0 = dp1
            dp1 = dp2
        return dp1