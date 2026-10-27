class Solution {
    public int longestPalindrome(String s) {
       int[] cnt=new int[128];
       int len=0;
       for(char c : s.toCharArray())
            len += (++cnt[c] % 2 ==0) ? 2 : 0;
        return len < s.length() ? len + 1 : len; 
    }
}