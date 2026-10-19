class Solution:
    def stoneGameV(self, stoneValue: List[int]) -> int:
        n = len(stoneValue)

        if n == 1:
            return 0

        prefix = [0] * (n + 1)

        for i in range(n):
            prefix[i + 1] = prefix[i] + stoneValue[i]

        dp = [[0] * n for _ in range(n)]
        best_left = [[0] * n for _ in range(n)]

        NEG = -10**30

        for r in range(n):
            for l in range(r - 1, -1, -1):
                value = (
                    prefix[r] - prefix[l]
                    + dp[l][r - 1]
                )

                if r - 1 > l:
                    best_left[l][r] = max(
                        best_left[l][r - 1],
                        value
                    )
                else:
                    best_left[l][r] = value

            best_right = [NEG] * (n + 1)
            best_right[r] = stoneValue[r]

            for l in range(r - 1, -1, -1):
                total = prefix[r + 1] - prefix[l]

                lo = l + 1
                hi = r

                while lo <= hi:
                    mid = (lo + hi) // 2

                    if 2 * (prefix[mid] - prefix[l]) <= total:
                        lo = mid + 1
                    else:
                        hi = mid - 1

                split = hi

                ans = NEG

                if split >= l + 1:
                    ans = best_left[l][split]

                start = split + 1

                if split >= l + 1:
                    if 2 * (prefix[split] - prefix[l]) == total:
                        start = split

                if start <= r:
                    ans = max(ans, best_right[start])

                dp[l][r] = ans

                best_right[l] = max(
                    best_right[l + 1],
                    prefix[r + 1] - prefix[l] + dp[l][r]
                )

        return dp[0][n - 1]