class Solution {

    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        return (int)Math.min(
            solve(landStartTime, landDuration, waterStartTime, waterDuration),
            solve(waterStartTime, waterDuration, landStartTime, landDuration)
        );
    }

    private long solve(int[] s1, int[] d1, int[] s2, int[] d2) {

        int n = s2.length;

        int[][] arr = new int[n][2];

        for(int i = 0; i < n; i++) {
            arr[i][0] = s2[i];
            arr[i][1] = d2[i];
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int[] start = new int[n];
        long[] pre = new long[n];
        long[] suf = new long[n];

        for(int i = 0; i < n; i++) {
            start[i] = arr[i][0];
        }

        pre[0] = arr[0][1];
        for(int i = 1; i < n; i++) {
            pre[i] = Math.min(pre[i - 1], arr[i][1]);
        }

        suf[n - 1] = (long)arr[n - 1][0] + arr[n - 1][1];
        for(int i = n - 2; i >= 0; i--) {
            suf[i] = Math.min(suf[i + 1],
                    (long)arr[i][0] + arr[i][1]);
        }

        long ans = Long.MAX_VALUE;

        for(int i = 0; i < s1.length; i++) {

            long finish = (long)s1[i] + d1[i];

            int pos = upperBound(start, (int)finish) - 1;

            if(pos >= 0)
                ans = Math.min(ans, finish + pre[pos]);

            if(pos + 1 < n)
                ans = Math.min(ans, suf[pos + 1]);
        }

        return ans;
    }

    private int upperBound(int[] arr, int x) {

        int l = 0, r = arr.length;

        while(l < r) {
            int m = l + (r - l) / 2;

            if(arr[m] <= x)
                l = m + 1;
            else
                r = m;
        }

        return l;
    }
}