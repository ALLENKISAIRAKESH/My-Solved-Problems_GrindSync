import java.util.*;

class MyQueue {

    /*
    🔥 APPROACH: Two Stacks (Amortized O(1))

    Idea:
    - Use TWO stacks:
        1. inStack  → for push operations
        2. outStack → for pop/peek operations

    Key trick:
    - When popping/peeking:
        → If outStack is empty → transfer all elements from inStack to outStack
        → This reverses order → FIFO behavior

    ⏱ Amortized Time: O(1)
    💾 Space: O(n)
    */

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }
    
    public void push(int x) {
        // always push to inStack
        inStack.push(x);
    }
    
    public int pop() {
        // ensure outStack has elements in correct order
        moveIfNeeded();
        return outStack.pop();
    }
    
    public int peek() {
        // ensure front element is ready
        moveIfNeeded();
        return outStack.peek();
    }
    
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    // helper to transfer elements only when needed
    private void moveIfNeeded() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}