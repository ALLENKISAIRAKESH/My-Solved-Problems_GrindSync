class Solution:
    def countServers(self, n: int, logs: List[List[int]], x: int, queries: List[int]) -> List[int]:
        logs.sort(key=lambda a: a[1])
        sorted_queries = sorted(enumerate(queries), key=lambda a: a[1])
        freq = defaultdict(int)
        ans = [0] * len(queries)
        left = 0
        right = 0
        active = 0
        m = len(logs)
        for idx, q in sorted_queries:
            while right < m and logs[right][1] <= q:
                server = logs[right][0]
                freq[server] += 1
                if freq[server] == 1:
                    active += 1
                right += 1
            while left < right and logs[left][1] < q - x:
                server = logs[left][0]
                freq[server] -= 1
                if freq[server] == 0:
                    active -= 1
                left += 1
            ans[idx] = n - active
        return ans
