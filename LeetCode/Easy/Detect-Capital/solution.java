class Solution {
    public boolean detectCapitalUse(String word) {

        /*
        🔥 APPROACH: Count Capitals

        Valid cases:
        1. All letters uppercase       → "USA"
        2. All letters lowercase       → "leetcode"
        3. Only first letter uppercase → "Google"

        Idea:
        - Count number of uppercase letters
        - Check conditions based on count

        ⏱ Time: O(n)
        💾 Space: O(1)
        */

        int n = word.length();
        int capitalCount = 0;

        // Step 1: count uppercase letters
        for (int i = 0; i < n; i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                capitalCount++;
            }
        }

        // Step 2: check valid conditions

        // Case 1: all uppercase
        if (capitalCount == n) return true;

        // Case 2: all lowercase
        if (capitalCount == 0) return true;

        // Case 3: only first letter uppercase
        if (capitalCount == 1 && Character.isUpperCase(word.charAt(0))) {
            return true;
        }

        return false;
    }
}