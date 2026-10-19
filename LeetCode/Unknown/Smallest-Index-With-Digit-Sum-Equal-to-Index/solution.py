class Solution:
    def smallestIndex(self, nums):
        for i in range(len(nums)):
            n = nums[i]
            s = 0
            while n:
                s += n % 10
                n //= 10
            if s == i:
                return i
        return -1