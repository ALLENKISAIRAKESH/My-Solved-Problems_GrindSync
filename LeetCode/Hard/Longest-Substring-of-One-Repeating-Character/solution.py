class Solution:
    def longestRepeating(self, s: str, queryCharacters: str, queryIndices: List[int]) -> List[int]:
        n = len(s)
        t = [['', '', 0, 0, 0] for _ in range(4 * n)]
        ln = [0] * (4 * n)
        def build(p, l, r):
            ln[p] = r - l + 1
            if l == r:
                t[p] = [s[l], s[l], 1, 1, 1]
                return
            m = (l + r) // 2
            build(p * 2, l, m)
            build(p * 2 + 1, m + 1, r)
            pull(p)
        def pull(p):
            a = t[p * 2]
            b = t[p * 2 + 1]
            t[p] = [a[0], b[1], a[2], b[3], max(a[4], b[4])]
            if a[1] == b[0]:
                t[p][4] = max(t[p][4], a[3] + b[2])
                if a[2] == ln[p * 2]:
                    t[p][2] = a[2] + b[2]
                if b[3] == ln[p * 2 + 1]:
                    t[p][3] = b[3] + a[3]
        def update(p, l, r, idx, ch):
            if l == r:
                t[p] = [ch, ch, 1, 1, 1]
                return
            m = (l + r) // 2
            if idx <= m:
                update(p * 2, l, m, idx, ch)
            else:
                update(p * 2 + 1, m + 1, r, idx, ch)
            pull(p)
        build(1, 0, n - 1)
        ans = []
        for ch, idx in zip(queryCharacters, queryIndices):
            update(1, 0, n - 1, idx, ch)
            ans.append(t[1][4])
        return ans