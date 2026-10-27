import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        /*
        🔥 APPROACH: Monotonic Decreasing Stack (Next Greater Element)

        Key idea:
        - For each day i → find first j > i such that:
              temperatures[j] > temperatures[i]
        - Answer = j - i

        👉 Use MONOTONIC DECREASING stack:
        - Stack stores indices
        - Stack maintains decreasing temperatures
        - When current temp > stack top → we found answer

        ⏱ Time: O(n)
        💾 Space: O(n)
        */

        int n = temperatures.length;
        int[] res = new int[n];

        Stack<Integer> stack = new Stack<>(); // stores indices

        for (int i = 0; i < n; i++) {

            // if current temp is higher → resolve previous days
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {

                int prevIndex = stack.pop();

                // number of days waited
                res[prevIndex] = i - prevIndex;
            }

            // push current index
            stack.push(i);
        }

        return res;
    }
}