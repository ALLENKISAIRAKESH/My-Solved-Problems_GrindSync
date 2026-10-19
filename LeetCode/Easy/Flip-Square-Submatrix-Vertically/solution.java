class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {

        /*
        🔥 APPROACH: Vertical Flip of k x k submatrix

        From problem :contentReference[oaicite:0]{index=0}:

        👉 We need to:
        - Take submatrix starting at (x, y)
        - Size = k x k
        - Reverse ROW order (vertical flip)

        --------------------------------------------

        💡 Idea:
        Swap rows:
            row x      ↔ row x + k - 1
            row x + 1  ↔ row x + k - 2
            ...

        Only within column range [y → y+k-1]

        --------------------------------------------

        ⏱ Time: O(k^2)
        💾 Space: O(1)
        */

        int top = x;
        int bottom = x + k - 1;

        // swap rows vertically inside submatrix
        while (top < bottom) {

            for (int col = y; col < y + k; col++) {
                int temp = grid[top][col];
                grid[top][col] = grid[bottom][col];
                grid[bottom][col] = temp;
            }

            top++;
            bottom--;
        }

        return grid;
    }
}