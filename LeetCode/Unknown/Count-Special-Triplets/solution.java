class Solution {
    public int specialTriplets(int[] nums) {

        /*
        🔥 APPROACH: PREFIX + SUFFIX COUNT

        From problem :contentReference[oaicite:0]{index=0}

        💡 Key Idea:

        We need:
        nums[i] == nums[j] * 2
        nums[k] == nums[j] * 2
        with i < j < k

        ------------------------------------------------

        Fix j as middle

        Count:
        - how many nums[i] = 2 * nums[j] on LEFT
        - how many nums[k] = 2 * nums[j] on RIGHT

        Multiply both

        ------------------------------------------------

        ⏱ Time: O(n)
        */

        int MOD = 1_000_000_007;
        int n = nums.length;

        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();

        // initialize right map
        for (int num : nums) {
            right.put(num, right.getOrDefault(num, 0) + 1);
        }

        long ans = 0;

        for (int j = 0; j < n; j++) {

            int curr = nums[j];

            // remove current from right
            right.put(curr, right.get(curr) - 1);

            int target = curr * 2;

            int leftCount = left.getOrDefault(target, 0);
            int rightCount = right.getOrDefault(target, 0);

            ans = (ans + (long) leftCount * rightCount) % MOD;

            // add current to left
            left.put(curr, left.getOrDefault(curr, 0) + 1);
        }

        return (int) ans;
    }
}