class Solution {
    public int countCollisions(String directions) {

        /*
        🔥 APPROACH: TRIM + COUNT

        From problem :contentReference[oaicite:0]{index=0}

        💡 Key Idea:

        Ignore:
        - leading 'L' → they go left forever (no collision)
        - trailing 'R' → they go right forever (no collision)

        ------------------------------------------------

        Remaining part:
        every moving car ('L' or 'R') will collide

        👉 Count all non-'S' in middle segment

        ------------------------------------------------

        ⏱ Time: O(n)
        */

        int n = directions.length();

        int left = 0;
        int right = n - 1;

        // skip leading 'L'
        while (left < n && directions.charAt(left) == 'L') {
            left++;
        }

        // skip trailing 'R'
        while (right >= 0 && directions.charAt(right) == 'R') {
            right--;
        }

        int collisions = 0;

        for (int i = left; i <= right; i++) {
            if (directions.charAt(i) != 'S') {
                collisions++;
            }
        }

        return collisions;
    }
}
