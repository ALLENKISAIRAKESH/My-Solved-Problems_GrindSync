class Solution {
    public long maxRunTime(int n, int[] batteries) {

        /*
        🔥 APPROACH: BINARY SEARCH + GREEDY CHECK

        From problem :contentReference[oaicite:0]{index=0}

        💡 Key Idea:

        We want maximum time T such that:
        we can run n computers simultaneously

        ------------------------------------------------

        For a given T:
        each battery can contribute at most min(battery, T)

        total power needed = n * T

        if sum(min(b, T)) >= n*T → feasible

        ------------------------------------------------

        Use binary search on T

        ------------------------------------------------

        ⏱ Time: O(n log sum)
        */

        long sum = 0;
        for (int b : batteries) sum += b;

        long left = 0;
        long right = sum / n; // max possible time

        while (left < right) {

            long mid = (left + right + 1) / 2;

            if (canRun(batteries, n, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private boolean canRun(int[] batteries, int n, long time) {

        long total = 0;

        for (int b : batteries) {
            total += Math.min(b, time);
        }

        return total >= n * time;
    }
}