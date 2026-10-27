class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        /*
        🔥 From problem :contentReference[oaicite:0]{index=0}:

        - Even rows → left shift k times
        - Odd rows  → right shift k times

        BUT:
        Cyclic shift → repeating pattern

        👉 So effective shift = k % n (n = number of columns)

        Then just check if after shift row becomes same
        */

        int m = mat.length;
        int n = mat[0].length;

        k %= n; // 🔥 important optimization

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int newIndex;

                if ((i & 1) == 0) {
                    // even row → left shift
                    newIndex = (j + k) % n;
                } else {
                    // odd row → right shift
                    newIndex = (j - k % n + n) % n;
                }

                if (mat[i][j] != mat[i][newIndex]) {
                    return false;
                }
            }
        }

        return true;
    }
}