class Solution:
    def minimumCost(self, cost1: int, cost2: int, costBoth: int, need1: int, need2: int) -> int:
        return min(
            need1 * cost1 + need2 * cost2,
            max(need1, need2) * costBoth,
            min(need1, need2) * costBoth
            + (need1 - min(need1, need2)) * cost1
            + (need2 - min(need1, need2)) * cost2
        )