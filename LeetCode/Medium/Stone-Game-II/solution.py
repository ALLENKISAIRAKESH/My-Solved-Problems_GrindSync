class Solution:
    def stoneGameII(self, piles):
        n = len(piles)
        s = [0] * (n + 1)
        for i in range(n - 1, -1, -1):
            s[i] = s[i + 1] + piles[i]
        dp = {}
        def solve(i, m):
            if i >= n:
                return 0
            if (i, m) in dp:
                return dp[(i, m)]
            ans = 0
            for x in range(1, 2 * m + 1):
                if i + x > n:
                    break
                nxt = solve(i + x, max(m, x))
                ans = max(ans, s[i] - nxt)
            dp[(i, m)] = ans
            return ans
        return solve(0, 1)