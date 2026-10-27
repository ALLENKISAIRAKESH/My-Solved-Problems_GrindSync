class Solution {
    public boolean rotateString(String s, String goal) {

        /*
        🔥 APPROACH: String Trick (Same as repetition concept)

        Key idea:
        - All rotations of s are present in (s + s)

        Example:
        s = "abcde"
        rotations:
        "bcdea", "cdeab", ...

        s + s = "abcdeabcde"
        → contains all rotations

        So:
        goal must be a substring of (s + s)

        ⚠️ Also lengths must match

        ⏱ Time: O(n)
        💾 Space: O(n)
        */

        // lengths must match
        if (s.length() != goal.length()) return false;

        // check if goal is rotation of s
        return (s + s).contains(goal);
    }
}