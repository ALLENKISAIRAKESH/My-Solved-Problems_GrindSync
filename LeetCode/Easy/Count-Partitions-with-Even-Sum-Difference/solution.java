class Solution {
    public int countPartitions(int[] nums) {

        /*
        🔥 APPROACH:

        From problem :contentReference[oaicite:0]{index=0}

        💡 Key Insight:

        We need:
        (leftSum - rightSum) is EVEN

        ------------------------------------------------

        Let total = left + right

        Then:
        left - right = EVEN
        ⇒ (left - (total - left)) = EVEN
        ⇒ (2 * left - total) = EVEN

        ------------------------------------------------

        Since 2 * left is always EVEN:

        ⇒ condition reduces to:
        total must be EVEN

        ------------------------------------------------

        💡 Final Result:

        If total is EVEN → all partitions valid → (n - 1)
        If total is ODD → none valid → 0

        ------------------------------------------------

        ⏱ Time: O(n)
        */

        int sum = 0;
        for (int num : nums) sum += num;

        if (sum % 2 == 0) {
            return nums.length - 1;
        } else {
            return 0;
        }
    }
}