class Solution:
    def minTime(self, n: int, s1: int, s2: int) -> int:
        low = 0
        high = n * min(s1, s2)
        while low < high:
            mid = (low + high) // 2
            total = mid // s1 + mid // s2
            if total >= n:
                high = mid
            else:
                low = mid + 1
        return low