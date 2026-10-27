class Solution:
    def countIslands(self, grid: List[List[int]], k: int) -> int:
        m, n = len(grid), len(grid[0])
        ans = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 0:
                    continue
                total = grid[i][j]
                stack = [(i, j)]
                grid[i][j] = 0
                while stack:
                    x, y = stack.pop()
                    for dx, dy in ((1, 0), (-1, 0), (0, 1), (0, -1)):
                        nx, ny = x + dx, y + dy
                        if 0 <= nx < m and 0 <= ny < n and grid[nx][ny] > 0:
                            total += grid[nx][ny]
                            stack.append((nx, ny))
                            grid[nx][ny] = 0
                if total % k == 0:
                    ans += 1
        return ans