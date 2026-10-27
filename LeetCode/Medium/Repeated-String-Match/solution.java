class Solution {
    public int repeatedStringMatch(String a, String b) {

        /*
        🔥 APPROACH: Build + Check (Greedy + String Matching)

        Key idea:
        - Keep repeating string 'a' until its length >= length of 'b'
        - Then check:
            1. If b is substring → return count
            2. Else add one more repetition → check again
            3. If still not → impossible

        👉 Why only +1 extra check?
        - Because b might overlap between boundaries

        ⏱ Time: O((n + m) * k)
        💾 Space: O(n * k)
        */

        StringBuilder sb = new StringBuilder();
        int count = 0;

        // Step 1: keep appending until length >= b
        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }

        // Step 2: check if b is substring
        if (sb.toString().contains(b)) {
            return count;
        }

        // Step 3: one more append (for overlap case)
        sb.append(a);
        count++;

        if (sb.toString().contains(b)) {
            return count;
        }

        // Step 4: not possible
        return -1;
    }
}