class Solution:
    def lexicographicallySmallestArray(self, nums: List[int], limit: int) -> List[int]:
        n = len(nums)
        a = sorted((v, i) for i, v in enumerate(nums))
        ans = nums[:]
        i = 0

        while i < n:
            j = i
            while j + 1 < n and a[j + 1][0] - a[j][0] <= limit:
                j += 1

            v = [a[k][0] for k in range(i, j + 1)]
            p = sorted(a[k][1] for k in range(i, j + 1))

            for k in range(len(v)):
                ans[p[k]] = v[k]

            i = j + 1

        return ans
        