class Solution {
    public int minMaxDifference(int num) {
        String s = num + "";

        char x = ' ';
        for (char c : s.toCharArray())
            if (c != '9') { x = c; break; }

        String max = (x == ' ') ? s : s.replace(x, '9');
        String min = s.replace(s.charAt(0), '0');

        return Integer.parseInt(max) - Integer.parseInt(min);
    }
}
