class Solution:
    def totalMoney(self, n: int) -> int:
        weeks = n // 7
        days = n % 7
        total = sum(7 * i + 28 for i in range(weeks))
        total += sum(weeks + 1 + d for d in range(days))
        return total
