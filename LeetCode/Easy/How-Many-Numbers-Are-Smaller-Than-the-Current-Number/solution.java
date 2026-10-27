class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        /*
        🔥 Best Approach: Counting Sort (since nums[i] <= 100)

        Steps:
        1. Count frequency of each number
        2. Build prefix sum → gives how many numbers < current
        3. Answer for each nums[i] = prefix[nums[i]]

        Time: O(n + 100)
        Space: O(100)
        */

        int[] freq = new int[101];

        // Step 1: count frequency
        for (int num : nums) {
            freq[num]++;
        }

        // Step 2: prefix sum
        for (int i = 1; i < 101; i++) {
            freq[i] += freq[i - 1];
        }

        int n = nums.length;
        int[] res = new int[n];

        // Step 3: build result
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                res[i] = 0;
            } else {
                res[i] = freq[nums[i] - 1];
            }
        }

        return res;
    }
}