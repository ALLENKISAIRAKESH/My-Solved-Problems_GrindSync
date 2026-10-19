class Solution:
    def gcdSum(self, nums: list[int]) -> int:
        from math import gcd

        prefix = []
        mx = 0

        for num in nums:
            mx = max(mx, num)
            prefix.append(gcd(num, mx))

        prefix.sort()

        ans = 0
        i, j = 0, len(prefix) - 1

        while i < j:
            ans += gcd(prefix[i], prefix[j])
            i += 1
            j -= 1

        return ans