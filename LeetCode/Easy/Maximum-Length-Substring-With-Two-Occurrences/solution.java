class Solution {
    public int maximumLengthSubstring(String s) {
        int[] a = new int[26];
        int l = 0, r = 0, m = 0;

        while (r < s.length()) {
            a[s.charAt(r) - 'a']++;

            while (a[s.charAt(r) - 'a'] > 2) {
                a[s.charAt(l) - 'a']--;
                l++;
            }

            m = Math.max(m, r - l + 1);
            r++;
        }

        return m;
    }
}