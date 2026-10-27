class Solution {
    public boolean repeatedSubstringPattern(String s) {

        /*
        🔥 APPROACH: String Trick (Most Elegant)

        Key idea:
        - If string is made by repeating a substring,
          then it will appear inside (s + s) after removing first & last char

        Why?
        - Repetition creates internal overlaps

        Example:
        s = "abab"
        s + s = "abababab"
        remove first & last → "bababa"
        "abab" exists inside → TRUE

        ⏱ Time: O(n)
        💾 Space: O(n)
        */

        String doubled = s + s;

        // remove first and last character
        String trimmed = doubled.substring(1, doubled.length() - 1);

        // check if original exists inside
        return trimmed.contains(s);
    }
}