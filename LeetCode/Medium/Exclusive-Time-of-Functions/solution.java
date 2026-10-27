import java.util.*;

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {

        /*
        🔥 APPROACH: Stack + Time Tracking

        Key idea:
        - Use stack to simulate function call stack
        - Keep track of "previous timestamp" (prevTime)

        Rules:
        1. On "start":
            - If stack NOT empty → add time to current running function
            - Push new function
            - Update prevTime

        2. On "end":
            - Pop function
            - Add (current time - prevTime + 1)
            - Update prevTime = time + 1

        ⚠️ Important:
        - "+1" because end timestamp is inclusive

        ⏱ Time: O(logs)
        💾 Space: O(n)
        */

        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        int prevTime = 0;

        for (String log : logs) {

            // parse log
            String[] parts = log.split(":");
            int id = Integer.parseInt(parts[0]);
            String type = parts[1];
            int time = Integer.parseInt(parts[2]);

            if (type.equals("start")) {

                // if some function is already running
                if (!stack.isEmpty()) {
                    res[stack.peek()] += time - prevTime;
                }

                // push new function
                stack.push(id);

                // update previous time
                prevTime = time;

            } else {
                // function ends

                // pop function
                int finished = stack.pop();

                // add execution time (+1 because inclusive)
                res[finished] += time - prevTime + 1;

                // move prevTime forward
                prevTime = time + 1;
            }
        }

        return res;
    }
}