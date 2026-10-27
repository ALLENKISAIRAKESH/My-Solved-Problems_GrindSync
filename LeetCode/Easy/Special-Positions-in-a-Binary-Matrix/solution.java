class Solution {
    public int numSpecial(int[][] mat) {

        /*
        🔥 APPROACH:

        From problem :contentReference[oaicite:0]{index=0}

        💡 Idea:
        A position (i, j) is special if:
        - mat[i][j] == 1
        - Row i has ONLY one '1'
        - Column j has ONLY one '1'

        ------------------------------------------------

        💡 Steps:
        1. Count number of 1s in each row
        2. Count number of 1s in each column
        3. Check cells where mat[i][j] == 1
           → row[i] == 1 AND col[j] == 1

        ------------------------------------------------

        ⏱ Time: O(m * n)
        */

        int m = mat.length;
        int n = mat[0].length;

        int[] row = new int[m];
        int[] col = new int[n];

        // count 1s in rows and columns
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }

        int count = 0;

        // find special positions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && row[i] == 1 && col[j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}