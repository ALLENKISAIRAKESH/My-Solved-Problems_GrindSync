class Solution:
    def lexicographicallyLargest(self, arr: list[int]) -> list[int]:
        n = len(arr)
        i = 0
        while i < n:
            j = i + 1
            while j < n and arr[j] % 2 == arr[i] % 2:
                j += 1
            arr[i:j] = sorted(arr[i:j], reverse=True)
            i = j
        return arr