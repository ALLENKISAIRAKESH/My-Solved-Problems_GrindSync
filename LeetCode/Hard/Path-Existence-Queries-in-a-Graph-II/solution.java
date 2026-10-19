import java.util.Arrays;

class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) {
            order[i] = i;
        }

        Arrays.sort(order, (a, b) -> nums[a] - nums[b]);

        int[] sortedIndex = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            sortedIndex[i] = order[i];
            rank[sortedIndex[i]] = i;
        }

        int LOG = 32 - Integer.numberOfLeadingZeros(n);
        int[][] jump = new int[n][LOG];

        int start = 0;
        for (int i = 0; i < n; i++) {
            while (start < i && nums[sortedIndex[i]] - nums[sortedIndex[start]] > maxDiff) {
                start++;
            }
            jump[i][0] = start;
        }

        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {
                jump[i][j] = jump[jump[i][j - 1]][j - 1];
            }
        }

        int[] answer = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {

            int left = rank[queries[q][0]];
            int right = rank[queries[q][1]];

            if (left > right) {
                int temp = left;
                left = right;
                right = temp;
            }

            if (left == right) {
                answer[q] = 0;
                continue;
            }

            int moves = 0;
            int current = right;

            for (int b = LOG - 1; b >= 0; b--) {
                if (jump[current][b] > left) {
                    current = jump[current][b];
                    moves += 1 << b;
                }
            }

            if (jump[current][0] <= left) {
                answer[q] = moves + 1;
            } else {
                answer[q] = -1;
            }
        }

        return answer;
    }
}