class Solution:
    def longestSubarrayDivK(self, arr, k):
        prefix_sum = 0
        first_index = {0: -1}
        max_len = 0
        for i in range(len(arr)):
            prefix_sum += arr[i]
            rem = prefix_sum % k
            if rem in first_index:
                max_len = max(max_len, i - first_index[rem])
            else:
                first_index[rem] = i
        return max_len