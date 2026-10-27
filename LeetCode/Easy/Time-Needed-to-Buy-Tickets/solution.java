class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {

        /*
        🔥 APPROACH: Count Contribution (No Queue Simulation)

        Key idea:
        - Think in "rounds" instead of simulating queue

        Person k needs = tickets[k] rounds

        For every person i:
        - If i <= k:
            they can buy at most min(tickets[i], tickets[k])
        - If i > k:
            they can buy at most min(tickets[i], tickets[k] - 1)

        👉 Why?
        - People after k don't get the last round (k finishes first)

        ⏱ Time: O(n)
        💾 Space: O(1)
        */

        int time = 0;

        for (int i = 0; i < tickets.length; i++) {

            if (i <= k) {
                // can participate in all rounds of k
                time += Math.min(tickets[i], tickets[k]);
            } else {
                // misses the last round when k finishes
                time += Math.min(tickets[i], tickets[k] - 1);
            }
        }

        return time;
    }
}