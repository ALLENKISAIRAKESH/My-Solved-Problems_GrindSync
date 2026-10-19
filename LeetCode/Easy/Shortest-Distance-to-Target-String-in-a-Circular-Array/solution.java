class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {

        /*
        🔥 APPROACH:

        From problem :contentReference[oaicite:0]{index=0}

        💡 Key Idea:

        Circular array → distance can go:
        - forward
        - backward

        For each occurrence of target:
        distance = min(|i - startIndex|,
                       n - |i - startIndex|)

        ------------------------------------------------

        ⏱ Time: O(n)
        */

        int n = words.length;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            if (words[i].equals(target)) {

                int diff = Math.abs(i - startIndex);

                int dist = Math.min(diff, n - diff);

                ans = Math.min(ans, dist);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
