class Solution {
    public char processStr(String s, long k) {

        long len = 0;
        long LIMIT = (long) 1e18;

        // Find final length
        for (char ch : s.toCharArray()) {

            if (Character.isLowerCase(ch)) {
                len++;
            }
            else if (ch == '*') {
                if (len > 0) len--;
            }
            else if (ch == '#') {
                len = Math.min(LIMIT, len * 2);
            }
        }

        if (k >= len) return '.';

        // Work backwards
        for (int i = s.length() - 1; i >= 0; i--) {

            char ch = s.charAt(i);

            if (Character.isLowerCase(ch)) {

                if (k == len - 1) {
                    return ch;
                }

                len--;
            }
            else if (ch == '*') {

                len++;
            }
            else if (ch == '#') {

                long oldLen = len / 2;

                if (k >= oldLen) {
                    k -= oldLen;
                }

                len = oldLen;
            }
            else if (ch == '%') {

                k = len - 1 - k;
            }
        }

        return '.';
    }
}