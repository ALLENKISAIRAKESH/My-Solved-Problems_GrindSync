class Solution:
    def maxPackages(self, arr: list[int], totalTime: int) -> int:
        window_sum = sum(arr[:totalTime])
        max_packages = window_sum
        for i in range(totalTime, len(arr)):
            window_sum += arr[i] - arr[i - totalTime]
            max_packages = max(max_packages, window_sum)
        return max_packages