class Solution {
    public int minPartitions(String n) {

        /*
        🔥 APPROACH:

        💡 Key Observation:
        We want minimum number of deci-binary numbers.

        A deci-binary number contains only digits {0,1}.

        👉 To build digit 'd', we need at least 'd' layers of 1s.

        So answer = maximum digit in the string

        -----------------------------------------

        Example:
        "32" → max digit = 3 → answer = 3

        -----------------------------------------

        ⏱ Time: O(n)
        */

        int max = 0;

        for (char ch : n.toCharArray()) {
            max = Math.max(max, ch - '0');
        }

        return max;
    }
}