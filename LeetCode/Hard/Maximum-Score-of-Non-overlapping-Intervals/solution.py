class Solution:
    def maximumWeight(self, intervals: List[List[int]]) -> List[int]:
        a = sorted((l, r, w, i) for i, (l, r, w) in enumerate(intervals))
        s = [x[0] for x in a]
        n = len(a)
        dp = [[(0, []) for _ in range(5)] for _ in range(n + 1)]
        for i in range(n - 1, -1, -1):
            l, r, w, idx = a[i]
            j = bisect_right(s, r)
            for k in range(1, 5):
                skip = dp[i + 1][k]
                ids = sorted(dp[j][k - 1][1] + [idx])
                take = (w + dp[j][k - 1][0], ids)
                if take[0] > skip[0] or (
                    take[0] == skip[0] and take[1] < skip[1]
                ):
                    dp[i][k] = take
                else:
                    dp[i][k] = skip
        return dp[0][4][1]