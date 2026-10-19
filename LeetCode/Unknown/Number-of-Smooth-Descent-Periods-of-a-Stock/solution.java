class Solution {
    public long getDescentPeriods(int[] prices) {

        /*
        🔥 APPROACH: LINEAR SCAN + COUNT STREAK

        From problem :contentReference[oaicite:0]{index=0}

        💡 Key Idea:

        A valid descent:
        prices[i] == prices[i-1] - 1

        ------------------------------------------------

        Maintain:
        streak = length of current valid descending sequence

        For each index:
        if valid → extend streak
        else → reset streak = 1

        ------------------------------------------------

        Add streak to answer each time

        ------------------------------------------------

        ⏱ Time: O(n)
        */

        long ans = 0;
        long streak = 1; // each element itself is valid

        for (int i = 0; i < prices.length; i++) {

            if (i > 0 && prices[i] == prices[i - 1] - 1) {
                streak++;   // extend sequence
            } else {
                streak = 1; // reset
            }

            ans += streak;
        }

        return ans;
    }
}