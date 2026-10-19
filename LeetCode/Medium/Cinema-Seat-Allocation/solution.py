class Solution:
    def maxNumberOfFamilies(self, n: int, reservedSeats: list[list[int]]) -> int:
        rows = {}
        for row, seat in reservedSeats:
            rows[row] = rows.get(row, 0) | (1 << seat)
        left = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5)
        middle = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7)
        right = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9)
        ans = (n - len(rows)) * 2
        for mask in rows.values():
            count = 0
            if mask & left == 0:
                count += 1
            if mask & right == 0:
                count += 1
            if count == 0 and mask & middle == 0:
                count = 1
            ans += count
        return ans