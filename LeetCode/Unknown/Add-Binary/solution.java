class Solution {
    public String addBinary(String a, String b) {

        /*
        🔥 APPROACH:

        💡 Idea:
        Just like normal addition from right → left

        Maintain:
        - carry
        - result (StringBuilder)

        -----------------------------------------

        💡 Steps:
        1. Start from last indices of both strings
        2. Add bits + carry
        3. Append (sum % 2)
        4. Update carry = sum / 2

        -----------------------------------------

        ⏱ Time: O(max(n, m))
        */

        int i = a.length() - 1;
        int j = b.length() - 1;

        int carry = 0;
        StringBuilder res = new StringBuilder();

        while (i >= 0 || j >= 0 || carry != 0) {

            int sum = carry;

            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';

            res.append(sum % 2);   // current bit
            carry = sum / 2;       // next carry
        }

        return res.reverse().toString();
    }
}