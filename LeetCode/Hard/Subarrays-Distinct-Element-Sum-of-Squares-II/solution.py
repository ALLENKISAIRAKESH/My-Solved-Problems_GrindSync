class Solution:
    def sumCounts(self, nums: List[int]) -> int:
        MOD = 10**9 + 7
        n = len(nums)
        sum1 = [0] * (4 * n)
        sum2 = [0] * (4 * n)
        lazy = [0] * (4 * n)
        def update(node, start, end, l, r):
            if l > end or r < start:
                return
            if l <= start and end <= r:
                length = end - start + 1
                sum2[node] = (
                    sum2[node] + 2 * lazy_add * sum1[node]
                    + length * lazy_add * lazy_add
                ) % MOD
                sum1[node] = (sum1[node] + length * lazy_add) % MOD
                lazy[node] = (lazy[node] + lazy_add) % MOD
                return
            mid = (start + end) // 2
            push(node, start, end)
            update(node * 2, start, mid, l, r)
            update(node * 2 + 1, mid + 1, end, l, r)
            sum1[node] = (sum1[node * 2] + sum1[node * 2 + 1]) % MOD
            sum2[node] = (sum2[node * 2] + sum2[node * 2 + 1]) % MOD
        def push(node, start, end):
            if lazy[node] == 0 or start == end:
                return
            mid = (start + end) // 2
            apply(node * 2, start, mid, lazy[node])
            apply(node * 2 + 1, mid + 1, end, lazy[node])
            lazy[node] = 0
        def apply(node, start, end, val):
            length = end - start + 1
            sum2[node] = (
                sum2[node] + 2 * val * sum1[node]
                + length * val * val
            ) % MOD
            sum1[node] = (sum1[node] + length * val) % MOD
            lazy[node] = (lazy[node] + val) % MOD
        last = {}
        ans = 0
        for i, x in enumerate(nums):
            lazy_add = 1
            update(1, 0, n - 1, last.get(x, 0), i)
            last[x] = i + 1
            ans = (ans + sum2[1]) % MOD
        return ans
