class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        // Use HashSet for O(1) obstacle lookup
        // Encode (x, y) into a single long
        java.util.Set<Long> set = new java.util.HashSet<>();
        for (int[] obs : obstacles) {
            long key = (((long)obs[0]) << 32) | (obs[1] & 0xffffffffL);
            set.add(key);
        }

        // Directions: North, East, South, West
        int[][] dirs = {
            {0, 1},   // North
            {1, 0},   // East
            {0, -1},  // South
            {-1, 0}   // West
        };

        int dir = 0; // start facing North
        int x = 0, y = 0;
        int maxDist = 0;

        for (int cmd : commands) {
            if (cmd == -2) {
                // turn left
                dir = (dir + 3) % 4;
            } else if (cmd == -1) {
                // turn right
                dir = (dir + 1) % 4;
            } else {
                // move step by step
                for (int i = 0; i < cmd; i++) {
                    int nx = x + dirs[dir][0];
                    int ny = y + dirs[dir][1];

                    long key = (((long)nx) << 32) | (ny & 0xffffffffL);

                    // stop if obstacle
                    if (set.contains(key)) break;

                    x = nx;
                    y = ny;

                    // update max squared distance
                    maxDist = Math.max(maxDist, x * x + y * y);
                }
            }
        }

        return maxDist;
    }
}