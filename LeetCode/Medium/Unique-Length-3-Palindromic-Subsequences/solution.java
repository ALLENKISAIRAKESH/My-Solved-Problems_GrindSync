class Solution {
    public int countPalindromicSubsequence(String s) {

        /*
        🔥 APPROACH:

        From problem :contentReference[oaicite:0]{index=0}

        💡 Key Idea:
        Palindrome of length 3 → form: x ? x

        So:
        - Fix first and last character (same)
        - Count unique middle characters between them

        ------------------------------------------------

        💡 Steps:

        For each character 'a' to 'z':
        1. Find first occurrence
        2. Find last occurrence
        3. Count unique chars in between

        Each unique middle char → 1 palindrome

        ------------------------------------------------

        ⏱ Time: O(26 * n) ≈ O(n)
        */

        int n = s.length();
        int ans = 0;

        for (char ch = 'a'; ch <= 'z'; ch++) {

            int first = -1, last = -1;

            // find first & last occurrence
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == ch) {
                    if (first == -1) first = i;
                    last = i;
                }
            }

            // need at least 3 length window
            if (first == -1 || last - first < 2) continue;

            // count unique middle chars
            Set<Character> set = new HashSet<>();
            for (int i = first + 1; i < last; i++) {
                set.add(s.charAt(i));
            }

            ans += set.size();
        }

        return ans;
    }
}