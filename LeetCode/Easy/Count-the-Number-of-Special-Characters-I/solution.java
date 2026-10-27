class Solution {
    public int numberOfSpecialChars(String word) {

        boolean[] small = new boolean[26];
        boolean[] capital = new boolean[26];

        for(char ch : word.toCharArray()) {

            if(ch >= 'a' && ch <= 'z') {
                small[ch - 'a'] = true;
            }
            else {
                capital[ch - 'A'] = true;
            }
        }

        int count = 0;

        // check both exist
        for(int i = 0; i < 26; i++) {
            if(small[i] && capital[i]) {
                count++;
            }
        }

        return count;
    }
}