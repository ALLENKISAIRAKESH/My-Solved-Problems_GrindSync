class Solution:
    def canPlaceFlowers(self, f: list[int], n: int) -> bool:
        L = len(f)
        for i in range(L):
            if f[i] == 0:
                if (i == 0 or f[i - 1] == 0) and (i == L - 1 or f[i + 1] == 0):
                    f[i] = 1
                    n -= 1
            if n <= 0:
                return True
        return n <= 0