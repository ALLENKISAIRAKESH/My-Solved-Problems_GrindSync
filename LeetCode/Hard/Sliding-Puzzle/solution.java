import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

class Solution {
    private static final String TARGET = "123450";

    // Valid swap positions for each index in the 2x3 board string
    private static final int[][] NEIGHBORS = {
        {1, 3},      // index 0
        {0, 2, 4},   // index 1
        {1, 5},      // index 2
        {0, 4},      // index 3
        {1, 3, 5},   // index 4
        {2, 4}       // index 5
    };

    public int slidingPuzzle(int[][] board) {
        String start = encode(board);

        if (TARGET.equals(start)) {
            return 0;
        }

        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);

        int moves = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                String current = queue.poll();

                if (TARGET.equals(current)) {
                    return moves;
                }

                int zeroIndex = current.indexOf('0');

                for (int nextIndex : NEIGHBORS[zeroIndex]) {
                    String nextState = swap(current, zeroIndex, nextIndex);

                    if (visited.add(nextState)) {
                        queue.offer(nextState);
                    }
                }
            }

            moves++;
        }

        return -1;
    }

    private String encode(int[][] board) {
        StringBuilder sb = new StringBuilder(6);
        for (int[] row : board) {
            for (int cell : row) {
                sb.append(cell);
            }
        }
        return sb.toString();
    }

    private String swap(String state, int i, int j) {
        char[] chars = state.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}