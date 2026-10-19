class Solution:
    def uniqueXorTriplets(self, nums: List[int]) -> int:
        MAXX = 2048  
        present = [False] * MAXX
        values = []
        for x in nums:
            if not present[x]:
                present[x] = True
                values.append(x)
        pair = [False] * MAXX
        for a in values:
            for b in values:
                pair[a ^ b] = True
        ans = [False] * MAXX
        for x in range(MAXX):
            if pair[x]:
                for v in values:
                    ans[x ^ v] = True
        return sum(ans)