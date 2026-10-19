class Solution:
    def minSwaps(self, nums: List[int]) -> int:
        def digit_sum(n):
            return sum(map(int, str(n)))
        arr = sorted(nums, key=lambda x: (digit_sum(x), x))
        pos = {v: i for i, v in enumerate(arr)}
        visited = [False] * len(nums)
        swaps = 0
        for i in range(len(nums)):
            if visited[i] or pos[nums[i]] == i:
                continue
            j = i
            count = 0
            while not visited[j]:
                visited[j] = True
                j = pos[nums[j]]
                count += 1
            swaps += count - 1
        return swaps