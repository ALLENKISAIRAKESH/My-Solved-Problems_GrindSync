class Solution {
    public String makeLargestSpecial(String s) {
        List<String> list = new ArrayList<>();
        int bal = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            bal += s.charAt(i) == '1' ? 1 : -1;
            if (bal == 0) {
                list.add("1" + makeLargestSpecial(s.substring(start + 1, i)) + "0");
                start = i + 1;
            }
        }
        list.sort(Collections.reverseOrder());
        return String.join("", list);
    }
}
