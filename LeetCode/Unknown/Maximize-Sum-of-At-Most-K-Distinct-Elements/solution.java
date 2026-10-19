import java.util.*;

class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for (int x : nums) set.add(x);

        int size = Math.min(k, set.size());
        int[] ans = new int[size];
        int idx = 0;
        for (int val : set) {
            if (idx == size) break;
            ans[idx++] = val;
        }
        return ans;
    }
}