class Solution:
    def countEdges(self, adj: list[list[int]]) -> int:
        count = 0

        for neighbors in adj:
            count += len(neighbors)

        return count // 2