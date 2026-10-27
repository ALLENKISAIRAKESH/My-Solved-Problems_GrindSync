class Solution {
    public int[] findErrorNums(int[] nums) {
        /*
        🔥 Best approach: Index marking (in-place)

        Mark visited by negating nums[index]

        If already negative → duplicate
        */

        int duplicate = -1;

        for (int num : nums) {
            int idx = Math.abs(num) - 1;

            if (nums[idx] < 0) {
                duplicate = Math.abs(num);
            } else {
                nums[idx] *= -1;
            }
        }

        int missing = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
                break;
            }
        }

        return new int[]{duplicate, missing};
    }
}