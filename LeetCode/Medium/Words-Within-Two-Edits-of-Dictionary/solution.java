class Solution {
    public List<String> twoEditWords(String[] q, String[] d) {

        List<String> res = new ArrayList<>();

        for (String a : q) {

            boolean ok = false;

            for (String b : d) {

                int cnt = 0;

                for (int i = 0; i < a.length(); i++) {
                    if (a.charAt(i) != b.charAt(i)) {
                        cnt++;
                        if (cnt > 2) break;
                    }
                }

                if (cnt <= 2) {
                    ok = true;
                    break;
                }
            }

            if (ok) res.add(a);
        }

        return res;
    }
}