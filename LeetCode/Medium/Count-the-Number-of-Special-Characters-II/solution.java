class Solution {
    public int numberOfSpecialChars(String word) {

        int[] small = new int[26];
        int[] cap = new int[26];

        for (int i = 0; i < 26; i++) {
            small[i] = -1;
            cap[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);

            if (Character.isLowerCase(ch)) {
                small[ch - 'a'] = i;
            } else {
                cap[ch - 'A'] = Math.min(cap[ch - 'A'], i);
            }
        }

        int count = 0;

        for (int i = 0; i < 26; i++) {

            if (small[i] != -1 &&
                cap[i] != Integer.MAX_VALUE &&
                small[i] < cap[i]) {

                count++;
            }
        }

        return count;
    }
}