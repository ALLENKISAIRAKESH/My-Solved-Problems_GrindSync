import java.util.*;

class Solution {
    public int minDeletion(String s, int k) {
        int[] freq = new int[26];
        int distinct = 0;
        for (char c : s.toCharArray()) {
            if (freq[c - 'a']++ == 0) distinct++;
        }
        if (distinct <= k) return 0;

        List<Integer> list = new ArrayList<>();
        for (int f : freq) if (f > 0) list.add(f);
        Collections.sort(list);

        int remove = distinct - k, ans = 0;
        for (int i = 0; i < remove; i++) ans += list.get(i);
        return ans;
    }
}