MOD = 10**9 + 7
MAX = 100000

pow10 = [1] * (MAX + 1)
for i in range(1, MAX + 1):
    pow10[i] = (pow10[i - 1] * 10) % MOD


class Solution:
    def sumAndMultiply(self, s: str, queries: List[List[int]]) -> List[int]:
        n = len(s)

        prefixSum = [0] * (n + 1)
        x = [0] * (n + 1)
        cnt = [0] * (n + 1)

        for i, ch in enumerate(s):
            d = int(ch)
            prefixSum[i + 1] = prefixSum[i] + d
            if d:
                x[i + 1] = (x[i] * 10 + d) % MOD
                cnt[i + 1] = cnt[i] + 1
            else:
                x[i + 1] = x[i]
                cnt[i + 1] = cnt[i]

        ans = []

        for l, r in queries:
            r += 1
            length = cnt[r] - cnt[l]
            val = (x[r] - x[l] * pow10[length]) % MOD
            digitSum = prefixSum[r] - prefixSum[l]
            ans.append((val * digitSum) % MOD)

        return ans