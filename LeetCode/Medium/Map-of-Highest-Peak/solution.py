from collections import deque

class Solution:
    def highestPeak(self, isWater: List[List[int]]) -> List[List[int]]:
        rows, cols = len(isWater), len(isWater[0])
        q = deque([(r, c) for r in range(rows) for c in range(cols) if isWater[r][c] == 1])
        for r in range(rows):
            for c in range(cols):
                if isWater[r][c] == 1:
                    isWater[r][c] = 0
                else:
                    isWater[r][c] = -1
        directions = [(0,1), (0,-1), (-1,0), (1, 0)]
        while q:
            r, c = q.popleft()
            for dr, dc in directions:
                nr, nc = r + dr, c + dc
                if 0 <= nr < rows and 0 <= nc < cols and isWater[nr][nc] == -1:
                    isWater[nr][nc] = isWater[r][c] + 1
                    q.append((nr, nc))

        return isWater
