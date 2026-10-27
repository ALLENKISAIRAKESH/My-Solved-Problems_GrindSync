class Solution {
    public String licenseKeyFormatting(String s, int k) {

        /*
        🔥 APPROACH: Reverse Build (Greedy)

        Key idea:
        - Ignore dashes
        - Process from RIGHT → easier grouping
        - Add characters in groups of size k
        - Insert '-' after every k chars
        - Convert to uppercase

        Why reverse?
        → First group may be smaller → easier from end

        ⏱ Time: O(n)
        💾 Space: O(n)
        */

        StringBuilder res = new StringBuilder();
        int count = 0;

        // Step 1: traverse from end
        for (int i = s.length() - 1; i >= 0; i--) {

            char ch = s.charAt(i);

            // skip dashes
            if (ch == '-') continue;

            // add dash after k characters
            if (count == k) {
                res.append('-');
                count = 0;
            }

            // add uppercase character
            res.append(Character.toUpperCase(ch));
            count++;
        }

        // Step 2: reverse result
        return res.reverse().toString();
    }
}