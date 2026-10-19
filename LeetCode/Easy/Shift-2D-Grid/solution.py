class Solution:
    def shiftGrid(self, grid: List[List[int]], k: int) -> List[List[int]]:
        m = len(grid)
        n = len(grid[0])
        total = m * n
        k %= total

        arr = [x for row in grid for x in row]
        arr = arr[-k:] + arr[:-k]

        return [arr[i * n:(i + 1) * n] for i in range(m)]