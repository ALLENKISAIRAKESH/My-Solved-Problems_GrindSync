class Solution {
    private int[][] stMax, stMin;
    private int[] lg;

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;

        buildSparseTables(nums);

        PriorityQueue<long[]> pq =
                new PriorityQueue<>((a, b) -> Long.compare(b[0], a[0]));

        for (int l = 0; l < n; l++) {
            long val = getValue(l, n - 1);
            pq.offer(new long[]{val, l, n - 1});
        }

        long ans = 0;

        while (k-- > 0) {
            long[] cur = pq.poll();

            long val = cur[0];
            int l = (int) cur[1];
            int r = (int) cur[2];

            ans += val;

            if (r > l) {
                pq.offer(new long[]{
                        getValue(l, r - 1),
                        l,
                        r - 1
                });
            }
        }

        return ans;
    }

    private void buildSparseTables(int[] nums) {
        int n = nums.length;

        lg = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            lg[i] = lg[i / 2] + 1;
        }

        int K = lg[n] + 1;

        stMax = new int[K][n];
        stMin = new int[K][n];

        for (int i = 0; i < n; i++) {
            stMax[0][i] = nums[i];
            stMin[0][i] = nums[i];
        }

        for (int j = 1; j < K; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                stMax[j][i] = Math.max(
                        stMax[j - 1][i],
                        stMax[j - 1][i + (1 << (j - 1))]
                );

                stMin[j][i] = Math.min(
                        stMin[j - 1][i],
                        stMin[j - 1][i + (1 << (j - 1))]
                );
            }
        }
    }

    private long getValue(int l, int r) {
        int len = r - l + 1;
        int j = lg[len];

        int mx = Math.max(
                stMax[j][l],
                stMax[j][r - (1 << j) + 1]
        );

        int mn = Math.min(
                stMin[j][l],
                stMin[j][r - (1 << j) + 1]
        );

        return (long) mx - mn;
    }
}