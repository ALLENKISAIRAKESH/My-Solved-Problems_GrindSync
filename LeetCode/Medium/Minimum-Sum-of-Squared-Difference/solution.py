class Solution:
    def minSumSquareDiff(self, a: list[int], b: list[int], k1: int, k2: int) -> int:
        k = k1 + k2
        d = [abs(x - y) for x, y in zip(a, b)]
        if sum(d) <= k:
            return 0
        l, r = 0, max(d)
        while l < r:
            m = (l + r) // 2
            if sum(max(0, x - m) for x in d) <= k:
                r = m
            else:
                l = m + 1
        d = [min(x, l) for x in d]
        k -= sum(max(0, x - l) for x in [abs(x - y) for x, y in zip(a, b)])
        d.sort(reverse=True)
        for i in range(min(k, len(d))):
            if d[i] == l and l > 0:
                d[i] -= 1
        return sum(x * x for x in d)