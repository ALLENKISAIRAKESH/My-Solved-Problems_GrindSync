class Solution:
    def findPairs(self, arr: list[int]) -> list[int]:
        n = len(arr)
        mp = {}
        for i in range(n):
            for j in range(i + 1, n):
                s = arr[i] + arr[j]
                mp.setdefault(s, []).append((i, j))
        for a in range(n):
            for b in range(a + 1, n):
                s = arr[a] + arr[b]
                for c, d in mp[s]:
                    if (a, b) < (c, d) and \
                       a != c and a != d and b != c and b != d:
                        return [a, b, c, d]
        return [-1, -1, -1, -1]