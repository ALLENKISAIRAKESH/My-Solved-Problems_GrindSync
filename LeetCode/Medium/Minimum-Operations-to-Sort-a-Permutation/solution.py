class Solution:
    def minOperations(self, nums: List[int]) -> int:
        n = len(nums)
        p = nums.index(0)

        inc = all(nums[(p + i) % n] == i for i in range(n))
        dec = all(nums[(p - i) % n] == i for i in range(n))

        ans = float('inf')

        if inc:
            ans = min(ans, p, n - p + 2)

        if dec:
            k = (p + 1) % n
            ans = min(ans, k + 1, n - k + 1)

        return ans if ans != float('inf') else -1
