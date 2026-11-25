class Solution:
    def minTime(self, a: int, b: int, d: int, l: int, r: int) -> int:
        MOD = 10**9 + 7
        c = a - b
        p = a + b

        def time(x):
            if x <= 0:
                return 0
            if x <= a:
                return x

            k = (x - a + c - 1) // c
            return k * p + x - k * c

        def prefix(n):
            if n <= 0:
                return 0

            if n <= a:
                return n * (n + 1) // 2

            ans = a * (a + 1) // 2
            y = n - a
            q, rem = divmod(y, c)

            s = c * (2 * a - c + 1) // 2

            ans += p * c * q * (q + 1) // 2
            ans += q * s

            k = q + 1
            ans += rem * k * p
            ans += rem * (2 * (a - c) + rem + 1) // 2

            return ans

        normal = time(d)

        low, high = 0, d

        while low < high:
            mid = (low + high + 1) // 2

            if time(mid) + 1 <= normal:
                low = mid
            else:
                high = mid - 1

        limit = low

        x1 = d - r
        x2 = d - l

        end = min(x2, limit)
        count = max(0, end - x1 + 1)

        ans = count

        left = max(1, x1)

        if left <= end:
            ans += prefix(end) - prefix(left - 1)

        remaining = (r - l + 1) - count
        ans += remaining * normal

        return ans % MOD