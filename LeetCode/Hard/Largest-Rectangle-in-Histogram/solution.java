class Solution {
    public int largestRectangleArea(int[] heights) {

        /*
        🔥 APPROACH: Monotonic Increasing Stack

        Goal:
        - For each bar → find largest rectangle using it as height

        Key idea:
        - When current height < stack top → we can compute area

        For popped element:
        height = heights[top]
        width = (current_index - previous_smaller_index - 1)

        Trick:
        - Add virtual 0 at end to flush stack

        ⏱ Time: O(n)
        💾 Space: O(n)
        */

        int n = heights.length;
        int maxArea = 0;

        java.util.Stack<Integer> stack = new java.util.Stack<>();

        for (int i = 0; i <= n; i++) {

            // treat end as height 0
            int currHeight = (i == n) ? 0 : heights[i];

            // maintain increasing stack
            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {

                int height = heights[stack.pop()];

                // if stack empty → width = i
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;

                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}