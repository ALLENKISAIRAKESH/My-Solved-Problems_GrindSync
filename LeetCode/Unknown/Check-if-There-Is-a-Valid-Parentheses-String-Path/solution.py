class Solution:
    def hasValidPath(self, grid: list[list[str]]) -> bool:
        m, n = len(grid), len(grid[0])
        if (m + n - 1) % 2:
            return False
        dp = {}
        def dfs(i, j, b):
            b += 1 if grid[i][j] == '(' else -1
            if b < 0:
                return False
            if i == m - 1 and j == n - 1:
                return b == 0
            if (i, j, b) in dp:
                return dp[(i, j, b)]
            ans = False
            if i + 1 < m:
                ans = ans or dfs(i + 1, j, b)
            if j + 1 < n:
                ans = ans or dfs(i, j + 1, b)
            dp[(i, j, b)] = ans
            return ans
        return dfs(0, 0, 0)