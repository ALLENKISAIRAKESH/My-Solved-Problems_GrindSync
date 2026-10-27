class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {

        /*
        🔥 APPROACH: TREE DFS + GREEDY CUT

        From problem :contentReference[oaicite:0]{index=0}

        💡 Key Idea:

        Traverse tree bottom-up

        For each subtree:
        - compute sum % k
        - if sum % k == 0 → we can "cut" here → forms a component

        ------------------------------------------------

        💡 Important:
        When subtree sum % k == 0:
        → increment answer
        → return 0 to parent (since it's cut)

        ------------------------------------------------

        ⏱ Time: O(n)
        */

        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        int[] ans = new int[1];

        dfs(0, -1, adj, values, k, ans);

        return ans[0];
    }

    private long dfs(int node, int parent, List<Integer>[] adj, int[] values, int k, int[] ans) {

        long sum = values[node];

        for (int nei : adj[node]) {
            if (nei == parent) continue;

            sum += dfs(nei, node, adj, values, k, ans);
        }

        // if divisible → cut here
        if (sum % k == 0) {
            ans[0]++;
            return 0; // don't pass upwards
        }

        return sum % k;
    }
}
