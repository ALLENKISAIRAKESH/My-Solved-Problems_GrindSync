class Solution:
    def minSumOfLengths(self, arr: list[int], target: int) -> int:
        n = len(arr)
        INF = n + 1
        best = [INF] * n
        ans = INF
        left = 0
        s = 0
        min_len = INF
        for right in range(n):
            s += arr[right]
            while s > target:
                s -= arr[left]
                left += 1
            if s == target:
                length = right - left + 1
                if left > 0 and best[left - 1] != INF:
                    ans = min(ans, length + best[left - 1])
                min_len = min(min_len, length)
            best[right] = min_len
        return -1 if ans == INF else ans