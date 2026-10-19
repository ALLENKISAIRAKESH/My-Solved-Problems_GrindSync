class Solution:
    def largestOverlap(self, a: List[List[int]], b: List[List[int]]) -> int:
        n = len(a)
        r = 0
        for x in range(-n + 1, n):
            for y in range(-n + 1, n):
                c = 0
                for i in range(n):
                    for j in range(n):
                        p, q = i + x, j + y
                        if 0 <= p < n and 0 <= q < n:
                            if a[i][j] and b[p][q]:
                                c += 1
                r = max(r, c)
        return r