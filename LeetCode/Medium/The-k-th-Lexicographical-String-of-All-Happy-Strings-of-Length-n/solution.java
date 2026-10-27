class Solution {
    public String getHappyString(int n, int k) {
        java.util.List<String> list = new java.util.ArrayList<>();
        backtrack(n, new StringBuilder(), list);
        return k > list.size() ? "" : list.get(k - 1);
    }

    private void backtrack(int n, StringBuilder cur, java.util.List<String> list) {
        if (cur.length() == n) {
            list.add(cur.toString());
            return;
        }
        for (char c : new char[]{'a', 'b', 'c'}) {
            if (cur.length() > 0 && cur.charAt(cur.length() - 1) == c) continue;
            cur.append(c);
            backtrack(n, cur, list);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}