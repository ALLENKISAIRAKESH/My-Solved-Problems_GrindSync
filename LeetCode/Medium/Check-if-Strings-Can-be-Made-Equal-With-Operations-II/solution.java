class Solution {
    public boolean checkStrings(String s1, String s2) {
        /*
        🔥 CORE IDEA (from problem :contentReference[oaicite:0]{index=0}):

        You can swap only indices with SAME parity (even-even or odd-odd)

        👉 That means:
        - even index characters can permute among themselves
        - odd index characters can permute among themselves

        ✅ So condition:
        - frequency of chars at even positions must match
        - frequency of chars at odd positions must match
        */

        int[] even = new int[26];
        int[] odd = new int[26];

        int n = s1.length();

        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                even[s1.charAt(i) - 'a']++;
                even[s2.charAt(i) - 'a']--;
            } else {
                odd[s1.charAt(i) - 'a']++;
                odd[s2.charAt(i) - 'a']--;
            }
        }

        // check both arrays are zero
        for (int i = 0; i < 26; i++) {
            if (even[i] != 0 || odd[i] != 0) return false;
        }

        return true;
    }
}