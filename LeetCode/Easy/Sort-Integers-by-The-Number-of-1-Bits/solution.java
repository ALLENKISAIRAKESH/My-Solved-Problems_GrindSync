class Solution {
    public int[] sortByBits(int[] arr) {

        /*
        🔥 APPROACH:

        From problem :contentReference[oaicite:0]{index=0}

        💡 Idea:
        Sort based on:
        1. Number of set bits (ascending)
        2. Value itself (ascending if tie)

        -----------------------------------------

        💡 Trick:
        Use Integer.bitCount(x) to count 1s

        -----------------------------------------

        ⏱ Time: O(n log n)
        */

        Integer[] temp = new Integer[arr.length];

        // convert to Integer[] for custom sorting
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }

        // custom sort
        java.util.Arrays.sort(temp, (a, b) -> {
            int bitsA = Integer.bitCount(a);
            int bitsB = Integer.bitCount(b);

            if (bitsA == bitsB) return a - b;
            return bitsA - bitsB;
        });

        // copy back to int[]
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }

        return arr;
    }
}