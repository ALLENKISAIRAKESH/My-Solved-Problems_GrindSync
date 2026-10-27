class Solution {
    public int countTriples(int n) {

        /*
        🔥 APPROACH:

        From problem :contentReference[oaicite:0]{index=0}

        💡 Key Idea:
        We need:
        a^2 + b^2 = c^2

        ------------------------------------------------

        Brute force:
        Try all (a, b)
        Check if sqrt(a^2 + b^2) is integer

        ------------------------------------------------

        ⏱ Time: O(n^2)
        (n ≤ 250 → OK)
        */

        int count = 0;

        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {

                int sum = a * a + b * b;
                int c = (int) Math.sqrt(sum);

                // check perfect square + within limit
                if (c * c == sum && c <= n) {
                    count++;
                }
            }
        }

        return count;
    }
}