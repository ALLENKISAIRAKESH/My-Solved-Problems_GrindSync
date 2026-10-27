class Solution {
    public int countStudents(int[] students, int[] sandwiches) {

        /*
        🔥 APPROACH: Counting (Better than Simulation)

        Key idea:
        - Only two types → 0 and 1
        - Count how many students want 0 and 1

        Then process sandwiches:
        - If top sandwich is 0:
            → if no student wants 0 → STOP
        - Else:
            → reduce count

        👉 No need to simulate queue (optimization)

        ⏱ Time: O(n)
        💾 Space: O(1)
        */

        int count0 = 0, count1 = 0;

        // Step 1: count student preferences
        for (int s : students) {
            if (s == 0) count0++;
            else count1++;
        }

        // Step 2: process sandwiches
        for (int s : sandwiches) {

            if (s == 0) {
                // no student wants circular sandwich
                if (count0 == 0) break;
                count0--;
            } else {
                // no student wants square sandwich
                if (count1 == 0) break;
                count1--;
            }
        }

        // remaining students = those who couldn't eat
        return count0 + count1;
    }
}