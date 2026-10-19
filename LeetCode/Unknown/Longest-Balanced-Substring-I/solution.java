class Solution {
    public int longestBalanced(String s) {

        /*
        🔥 APPROACH:

        From problem :contentReference[oaicite:0]{index=0}

        💡 Idea:
        For each substring:
        - Count frequency of characters
        - Check if all non-zero frequencies are equal

        ------------------------------------------------

        💡 Optimization:
        - Fix start i
        - Expand j
        - Maintain freq array
        - Track:
            maxFreq, distinct count

        Valid if:
            substring length == distinct * maxFreq

        ------------------------------------------------

        ⏱ Time: O(n^2 * 26) → OK since n ≤ 1000
        */

        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n; i++) {

            int[] freq = new int[26];
            int distinct = 0;
            int maxFreq = 0;

            for (int j = i; j < n; j++) {

                int idx = s.charAt(j) - 'a';

                if (freq[idx] == 0) distinct++;
                freq[idx]++;

                maxFreq = Math.max(maxFreq, freq[idx]);

                int len = j - i + 1;

                // 🔥 condition: all chars have equal freq
                if (len == distinct * maxFreq) {
                    ans = Math.max(ans, len);
                }
            }
        }

        return ans;
    }
}