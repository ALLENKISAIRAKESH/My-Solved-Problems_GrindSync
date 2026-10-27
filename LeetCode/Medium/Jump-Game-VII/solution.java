class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {

        int n = s.length();

        boolean[] vis = new boolean[n];
        vis[0] = true;

        int far = 0;

        for (int i = 0; i < n; i++) {

            if (!vis[i])
                continue;

            int start = Math.max(i + minJump, far);
            int end = Math.min(i + maxJump, n - 1);

            for (int j = start; j <= end; j++) {

                if (s.charAt(j) == '0')
                    vis[j] = true;
            }

            far = end + 1;
        }

        return vis[n - 1];
    }
}