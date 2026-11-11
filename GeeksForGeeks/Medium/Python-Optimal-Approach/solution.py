class Solution:
    def checkWithinK(self, arr: list[int], k: int) -> bool:
        seen = {}
        for i in range(len(arr)):
            if arr[i] in seen and i - seen[arr[i]] <= k:
                return True
            seen[arr[i]] = i
        return False