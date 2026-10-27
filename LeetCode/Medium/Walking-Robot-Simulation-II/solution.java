class Robot {

    // Directions: 0 = East, 1 = North, 2 = West, 3 = South
    private int dir = 0;
    private int x = 0, y = 0;

    private int width, height;
    private int perimeter;
    private boolean moved = false;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;

        // total cycle length (boundary walk)
        this.perimeter = 2 * (width + height) - 4;
    }

    public void step(int num) {
        // mark that robot has moved at least once
        moved = true;

        // reduce unnecessary full cycles
        num %= perimeter;

        // special case:
        // if num == 0 after mod → we should still update direction
        if (num == 0) {
            num = perimeter;
        }

        while (num > 0) {
            if (dir == 0) { // East
                int move = Math.min(num, width - 1 - x);
                x += move;
                num -= move;
                if (move == 0) dir = 1; // turn North
            } 
            else if (dir == 1) { // North
                int move = Math.min(num, height - 1 - y);
                y += move;
                num -= move;
                if (move == 0) dir = 2; // turn West
            } 
            else if (dir == 2) { // West
                int move = Math.min(num, x);
                x -= move;
                num -= move;
                if (move == 0) dir = 3; // turn South
            } 
            else { // South
                int move = Math.min(num, y);
                y -= move;
                num -= move;
                if (move == 0) dir = 0; // turn East
            }
        }
    }

    public int[] getPos() {
        return new int[]{x, y};
    }

    public String getDir() {
        // 🔥 important edge case:
        // before any movement → always "East"
        if (!moved) return "East";

        if (dir == 0) return "East";
        if (dir == 1) return "North";
        if (dir == 2) return "West";
        return "South";
    }
}