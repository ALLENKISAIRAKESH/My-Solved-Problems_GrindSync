class Solution {
    public int countOdds(int low, int high) {

        /*
        🔥 APPROACH:

        From problem :contentReference[oaicite:0]{index=0}

        💡 Key Idea:

        Count of numbers = (high - low + 1)

        Half of them are odd, BUT:
        If both low and high are odd → one extra odd

        ------------------------------------------------

        Formula:

        (high - low) / 2 + (low % 2 == 1 || high % 2 == 1 ? 1 : 0)

        OR cleaner:

        (high + 1) / 2 - (low / 2)

        ------------------------------------------------

        ⏱ Time: O(1)
        */

        return (high + 1) / 2 - (low / 2);
    }
}