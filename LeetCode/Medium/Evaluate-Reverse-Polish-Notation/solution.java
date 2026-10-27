import java.util.*;

class Solution {
    public int evalRPN(String[] tokens) {

        /*
        🔥 APPROACH: Stack Simulation

        Key idea:
        - Traverse tokens
        - If number → push to stack
        - If operator → pop 2 elements, apply operation, push result

        ⚠️ Important:
        - Order matters for '-' and '/'
          second popped = first operand

        ⏱ Time: O(n)
        💾 Space: O(n)
        */

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            // If operator → process
            if (token.equals("+") || token.equals("-") ||
                token.equals("*") || token.equals("/")) {

                // pop two operands
                int b = stack.pop(); // second operand
                int a = stack.pop(); // first operand

                int res = 0;

                if (token.equals("+")) {
                    res = a + b;
                } else if (token.equals("-")) {
                    res = a - b;
                } else if (token.equals("*")) {
                    res = a * b;
                } else {
                    res = a / b; // truncates toward zero
                }

                // push result back
                stack.push(res);

            } else {
                // number → push
                stack.push(Integer.parseInt(token));
            }
        }

        // final result
        return stack.pop();
    }
}