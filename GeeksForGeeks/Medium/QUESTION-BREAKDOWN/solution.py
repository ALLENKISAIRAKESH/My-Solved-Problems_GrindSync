class Solution:
    def getMinimumDays(self, s: str, p: list[int]) -> int:
        # code here
        n = len(s)
        def check(days):
            arr = list(s)
            for i in range(days):
                arr[p[i]] = '?'
            for i in range(n - 1):
                if arr[i] != '?' and arr[i] == arr[i + 1]:
                    return False
            return True
        low, high = 0, n
        while low < high:
            mid = (low + high) // 2
            if check(mid):
                high = mid
            else:
                low = mid + 1
        return low