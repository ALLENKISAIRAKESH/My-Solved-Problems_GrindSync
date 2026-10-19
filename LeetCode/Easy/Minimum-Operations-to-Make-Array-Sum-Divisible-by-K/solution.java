class Solution {
    public int minOperations(int[] nums, int k) {

        /*
        🔥 APPROACH:

        From problem :contentReference[oaicite:0]{index=0}

        💡 Key Idea:

        We can only DECREASE numbers

        Let total sum = S

        We want:
        S % k == 0

        ------------------------------------------------

        💡 Minimum operations:
        We need to remove remainder

        ops = S % k

        ------------------------------------------------

        Because each operation reduces sum by 1

        ------------------------------------------------

        ⏱ Time: O(n)
        */

        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        return sum % k;
    }
}