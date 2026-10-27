class Solution {
    public int maxRepeating(String sequence, String word) {
        int ans = 0;
        StringBuilder sb = new StringBuilder(word);
        while (sequence.contains(sb.toString())) {
            ans++;
            sb.append(word);
        }
        return ans;
    }
}